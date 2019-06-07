package com.gmail.kaminski.viktar.shop.service.converter;

import com.gmail.kaminski.viktar.shop.repository.model.Discount;
import com.gmail.kaminski.viktar.shop.service.model.DiscountDTO;
import com.gmail.kaminski.viktar.shop.service.model.NewDiscountDTO;

public interface DiscountConverter {
    Discount toDiscount(DiscountDTO discountDTO);

    DiscountDTO toDiscountDTO(Discount discount);

    Discount toDiscount(NewDiscountDTO discountDTO);
}
