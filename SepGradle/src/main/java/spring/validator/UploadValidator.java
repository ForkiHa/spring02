package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.controller.ReportCommand;

public class UploadValidator implements Validator {

	public boolean supports(Class<?> clazz){
		return ReportCommand.class.isAssignableFrom(clazz);
		
	}
	
	public void validate(Object target, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentNumber", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "report", "required");
	}
}
