package com.accenture.validator;

import java.lang.reflect.InvocationTargetException;
import java.text.Annotation;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.accenture.validator.annotation.ListSizeLimitation;

public class ListSizeLimitationValidator implements ConstraintValidator<ListSizeLimitation, Object> {
	private String field;
	private String verifiedField;

	public void initialize(ListSizeLimitation listSizeLimitation) {
	
		this.field = listSizeLimitation.listFieldName();// persons
		this.verifiedField = listSizeLimitation.limitedFieldName();// start && interval

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		try {

			String[] fieldValue = BeanUtils.getArrayProperty(value, field);
			String verifyFieldValue = BeanUtils.getProperty(value, verifiedField);
			//if(verifyFieldValue!=null)
			if (verifyFieldValue!=null&&Integer.parseInt(verifyFieldValue) <= fieldValue.length) {
				return true;
			} else{
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addNode(verifiedField).addConstraintViolation();
				return false;}
				
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			return false;
		}
		
		
			 

	}

}
