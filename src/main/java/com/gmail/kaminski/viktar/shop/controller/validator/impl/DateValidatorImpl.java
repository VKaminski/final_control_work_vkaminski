package com.gmail.kaminski.viktar.shop.controller.validator.impl;

import com.gmail.kaminski.viktar.shop.controller.validator.DateValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateValidatorImpl implements DateValidator {
    @Value("${custom.date.format}")
    private String dateFormat;
    @Override
    public String valid(String date, Long expirationYear) {
        if (date == null) {
            return "Date must be null!";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            Date dateValid = sdf.parse(date);
            Long futureTime = System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000 * expirationYear;
            if (dateValid.getTime() < futureTime){
                return "Date must be more!";
            }
        } catch (ParseException e) {
            return "Date has wrong format";
        }
        return null;
    }
}
