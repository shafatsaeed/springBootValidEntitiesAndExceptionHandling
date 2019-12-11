package com.tech.register.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {
    String message() default "above 18 are allowed only";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}