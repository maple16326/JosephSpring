package com.accenture.validator;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.accenture.validator.annotation.NoRepetitionList;

public class NoRepetitionListValidator implements ConstraintValidator<NoRepetitionList, List<?>> {

	public NoRepetitionListValidator() {

	}

	@Override
	public boolean isValid(List<?> value, ConstraintValidatorContext context) {
		if (value != null) {
			Set personsNoRepetiton = new HashSet(value);
			if (personsNoRepetiton.size() == value.size())
				return true;
			else
				return false;
		}
		else 
			return true;
	}

}
