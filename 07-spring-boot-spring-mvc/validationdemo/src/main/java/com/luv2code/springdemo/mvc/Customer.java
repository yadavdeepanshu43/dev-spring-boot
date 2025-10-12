package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validate.CourceCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName="";

    public String getPostalCode() {
        return postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @CourceCode
    private String courseCode;

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 char/digits")
    private String postalCode;

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater or equal to zero")
    @Max(value = 10, message = "must be less or equal to 10")
    private Integer freePasses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
