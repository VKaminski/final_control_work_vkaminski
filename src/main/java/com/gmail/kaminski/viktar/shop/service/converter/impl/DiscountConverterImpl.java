package com.gmail.kaminski.viktar.shop.service.converter.impl;

import com.gmail.kaminski.viktar.shop.repository.model.Discount;
import com.gmail.kaminski.viktar.shop.service.converter.DiscountConverter;
import com.gmail.kaminski.viktar.shop.service.exception.DateFormatException;
import com.gmail.kaminski.viktar.shop.service.model.DiscountDTO;
import com.gmail.kaminski.viktar.shop.service.model.NewDiscountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DiscountConverterImpl implements DiscountConverter {
    private static final Logger logger = LoggerFactory.getLogger(DiscountConverterImpl.class);
    private static final Marker custom = MarkerFactory.getMarker("custom");
    @Value("${custom.date.format}")
    private String dateFormat;

    @Override
    public Discount toDiscount(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        if (discountDTO.getId() != null) {
            discount.setId(discountDTO.getId());
        }
        discount.setName(discountDTO.getName());
        discount.setRate(discountDTO.getRate());
        discount.setExpirationDate(discountDTO.getExpirationDate());
        return discount;
    }

    @Override
    public DiscountDTO toDiscountDTO(Discount discount) {
        DiscountDTO discountDTO = new DiscountDTO();
        if (discount.getId() != null) {
            discountDTO.setId(discount.getId());
        }
        discountDTO.setName(discount.getName());
        discountDTO.setRate(discount.getRate());
        discountDTO.setExpirationDate(discount.getExpirationDate());
        return discountDTO;
    }

    @Override
    public Discount toDiscount(NewDiscountDTO discountDTO) {
        Discount discount = new Discount();
        discount.setName(discountDTO.getName());
        discount.setRate(discountDTO.getRate());
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            Date dateValid = sdf.parse(discountDTO.getExpirationDate());
            discount.setExpirationDate(dateValid);
        } catch (ParseException e) {
            logger.debug(custom, "Incorrect date format: " + discountDTO.getExpirationDate());
            throw new DateFormatException("Wrong date format", e);
        }
        return discount;
    }
}
