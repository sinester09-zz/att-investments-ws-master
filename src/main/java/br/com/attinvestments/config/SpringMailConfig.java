package br.com.attinvestments.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Configuration
public class SpringMailConfig {
	
	public static final String EMAIL_TEMPLATE_ENCODING = "UTF-8";
	
	@Autowired
	private Environment env;
	
	@Bean
    public JavaMailSender mailSender() throws IOException {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        
        mailSender.setProtocol(env.getProperty("spring.mail.protocol"));
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.properties.mail.smtp.socketFactory.port")));
        
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));        
        mailSender.setDefaultEncoding(env.getProperty("spring.mail.defaultEncoding"));
        
        mailProperties.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
        mailProperties.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
        mailProperties.put("mail.smtp.debug", env.getProperty("mail.smtp.debug"));

        mailProperties.put("mail.smtp.socketFactory.port", env.getProperty("spring.mail.properties.mail.smtp.socketFactory.port"));
        mailProperties.put("mail.smtp.socketFactory.class", env.getProperty("spring.mail.properties.mail.smtp.socketFactory.class"));

        mailProperties.put("mail.smtps.ssl.trust", env.getProperty("spring.mail.properties.mail.smtp.ssl.trust"));
        
        mailSender.setJavaMailProperties(mailProperties);
        return mailSender;
    }

	@Bean
	public TemplateEngine emailTemplateEngine() {
		final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.addTemplateResolver(htmlTemplateResolver());
		templateEngine.addTemplateResolver(stringTemplateResolver());
		return templateEngine;
	}

	private ITemplateResolver htmlTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setOrder(Integer.valueOf(2));
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(EMAIL_TEMPLATE_ENCODING);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
	
	private ITemplateResolver stringTemplateResolver() {
        final StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setOrder(Integer.valueOf(3));
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

}
