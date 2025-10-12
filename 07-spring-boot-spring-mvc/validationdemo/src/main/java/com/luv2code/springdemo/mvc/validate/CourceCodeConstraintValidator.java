package com.luv2code.springdemo.mvc.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourceCodeConstraintValidator implements ConstraintValidator<CourceCode, String> {


    private String coursePrefix;
    @Override
    public void initialize(CourceCode theCourceCode) {
        coursePrefix= theCourceCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theconstraintValidatorContext) {
        Boolean result;
        if(theCode!=null) {
            result=theCode.startsWith(coursePrefix);
        }
        else {
            result=true;
        }
        return result;

    }
}
