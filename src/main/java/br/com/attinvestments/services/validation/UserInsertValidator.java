package br.com.attinvestments.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.attinvestments.domain.User;
import br.com.attinvestments.dto.UserNewDTO;
import br.com.attinvestments.repositories.UserRepository;
import br.com.attinvestments.resources.exception.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsert, UserNewDTO> {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void initialize(UserInsert ann) {}
	
	@Override
	public boolean isValid(UserNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		User aux = userRepo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
