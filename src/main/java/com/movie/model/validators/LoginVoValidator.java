package com.movie.model.validators;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;

import com.movie.exceptions.MessageException;
import com.movie.model.vo.LoginVO;


@Service
public class LoginVoValidator {

	Validator validator;
	
	public LoginVoValidator() {
		validator = Validation.buildDefaultValidatorFactory()
	            .getValidator();
	}
	
	public void run(LoginVO loginVO) {
		Set<String> errorsValidation = new HashSet<>();
		
		for(ConstraintViolation<?> violation: validator.validate(loginVO)) {
			errorsValidation.add(violation.getMessage());
		}
		
		if(!errorsValidation.isEmpty()) {
			throw new MessageException(errorsValidation.toString());
		}
	}
	
        
        
        
}
