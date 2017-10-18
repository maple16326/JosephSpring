package com.accenture.validator;

import java.util.HashSet;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.accenture.validator.annotation.NoRepetitionList;

public class NoRepetitionListValidator implements ConstraintValidator<NoRepetitionList, List<?>> {

	public NoRepetitionListValidator() {

	}

	@Override
	public boolean isValid(List<?> value, ConstraintValidatorContext context) {
		for (int i = 0; i < value.size() - 1; i++) {
			Object temp = value.get(i);
			for (int j = i + 1; j < value.size(); j++) {
				if (temp.equals(value.get(j))) {

					return false;
				}
			}
		}
		return true;
	

	}

}
