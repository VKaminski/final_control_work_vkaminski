package com.gmail.kaminski.viktar.shop.service;

import com.gmail.kaminski.viktar.shop.service.model.DiscountDTO;
import com.gmail.kaminski.viktar.shop.service.model.NewDiscountDTO;

import java.util.List;

public interface DiscountService {
    void add(Long userId, NewDiscountDTO discountDTO);

    List<DiscountDTO> findAllDiscountForUser(Long userId);

    void delete(Long discountId);
}
