package br.com.attinvestments.services.impl;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.attinvestments.domain.Role;
import br.com.attinvestments.domain.User;
import br.com.attinvestments.domain.UserRole;
import br.com.attinvestments.dto.ConfirmEmailDTO;
import br.com.attinvestments.dto.UserNewDTO;
import br.com.attinvestments.repositories.RoleRepository;
import br.com.attinvestments.repositories.UserProfileRepository;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getSimpleName());
	
	private static final String EMAIL_TEMPLATE_CLASSPATH = "email/confirmacaoEmail.html";
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserProfileRepository userProfileRepo;
	
	@Autowired
	private Environment env;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine emailTemplateEngine;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Value("${jwt.secret.pwd}")
	private String secret;
	
	private Locale locale = new Locale("Portuguese", "Brazil", "pt_BR");
	private String confirmToken;

	@Override
	public User fromDTO(UserNewDTO objDto) {
		this.confirmToken = this.generateToken( objDto.getEmail() + objDto.getUsername() );
		User user = new User();
		user.setId(null);
		user.setUsername(objDto.getUsername());
		user.setPassword( bCryptPasswordEncoder.encode( objDto.getPassword() ) );
		user.setEmail(objDto.getEmail());
		user.setLanguageType(objDto.getLanguage());
		user.setPolicy(objDto.getPolicy());
		user.setResetPwd(false);
		user.setValidatedEmail(false); 
		user.setCreated(LocalDateTime.now()); 
		user.setUpdated(null);
		return user;
	}

	@Override
	@Transactional
	public User insert(User obj) {
		obj = userRepo.save(obj);
		Optional<Role> role = roleRepo.findById(2L);
		userProfileRepo.save(new UserRole(obj, role.get()));	
		this.sendConfirmationMail(obj);
		return obj;
	}
	
	private void sendConfirmationMail(User user) {
		final Context ctx = new Context(locale);
		ctx.setVariable("username", user.getUsername());
		ctx.setVariable("linkConfirm", (env.getProperty("att.url.portal") + "/validated-mail;token=" + confirmToken + ";email=" + user.getEmail()));
		final String htmlContent = this.emailTemplateEngine.process(EMAIL_TEMPLATE_CLASSPATH, ctx);
		try {
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
			
			message.setText(htmlContent, true /* isHtml */);
			message.setSubject("Confirmação de e-mail");
			message.setFrom(env.getProperty("spring.mail.username"));
			message.setTo(user.getEmail());

			// Send mail
			this.mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			logger.error("[UserServiceImpl][insert.sendConfirmationMail] error: ", e);
		}		
	}

	@Override
	@Transactional
	public String validToken(ConfirmEmailDTO confirm) {
		User user = userRepo.findByEmail(confirm.getEmail());
		if (user != null) { 
			String token = this.generateToken( user.getEmail() + user.getUsername() );
			if(confirm.getToken().equals(token)) {
				user.setValidatedEmail(true);
				user.setUpdated(LocalDateTime.now());
				userRepo.save(user);
				return (env.getProperty("att.url.portal") + "/confirmationToken");
			}			
		}
		return (env.getProperty("att.url.portal") + "/invalidToken");
	}
	
	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}

}
