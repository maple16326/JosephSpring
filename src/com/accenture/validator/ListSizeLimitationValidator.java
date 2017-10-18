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
	private String verifyField;

	public void initialize(ListSizeLimitation listSizeLimitation) {
		this.field = listSizeLimitation.limitedFieldName();
		this.verifyField = listSizeLimitation.listFieldName();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		try {

			String[] fieldValue = BeanUtils.getArrayProperty(value, field);
			String verifyFieldValue = BeanUtils.getProperty(value, verifyField);
			if (Integer.parseInt(verifyFieldValue) <= fieldValue.length) {
				return true;
			} 
		} catch (IllegalAccessException e) {
			
		} catch (InvocationTargetException e) {
			
		} catch (NoSuchMethodException e) {
			
		}
		return false;
		
		
	}

}
