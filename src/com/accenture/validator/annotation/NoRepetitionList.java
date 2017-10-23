package com.accenture.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.accenture.validator.NoRepetitionListValidator;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
@Constraint(validatedBy = NoRepetitionListValidator.class)
public @interface NoRepetitionList {
String message() default "The field is repetiton.";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default{};
    
}
 