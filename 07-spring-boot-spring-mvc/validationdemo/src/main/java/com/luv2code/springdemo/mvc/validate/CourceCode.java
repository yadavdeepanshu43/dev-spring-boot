package com.luv2code.springdemo.mvc.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourceCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourceCode {

    //define default cource code

    public String value() default "LUV";
    //define defailt error message

    public String message() default "musr Start with LUV";
    //define Group
    public Class<?>[] groups() default {};

    //define default payload
    public Class<? extends Payload>[] payload() default {};
}
