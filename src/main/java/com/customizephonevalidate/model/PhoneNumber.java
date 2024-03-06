package com.customizephonevalidate.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class PhoneNumber implements Validator {
    String phoneNumber;
    public PhoneNumber() {
    }

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    PhoneNumber phoneNumber = (PhoneNumber) target;
    String number = phoneNumber.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber","number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber","number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber","number.matches");
        }
    }
}
