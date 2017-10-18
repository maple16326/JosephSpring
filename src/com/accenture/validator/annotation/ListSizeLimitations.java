package com.accenture.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface ListSizeLimitations {
	ListSizeLimitation[] value();
String message() default "The field is Longer than persons.";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default{};
}
 