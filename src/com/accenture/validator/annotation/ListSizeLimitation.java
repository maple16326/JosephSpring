package com.accenture.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.accenture.validator.ListSizeLimitationValidator;


@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
@Constraint(validatedBy = ListSizeLimitationValidator.class)
@Repeatable(ListSizeLimitations.class)
public @interface ListSizeLimitation {
	String listFieldName();// start interval

	String limitedFieldName();// persons

	String message() default "The field is out of limits";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
 