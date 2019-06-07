package com.gmail.kaminski.viktar.shop.service.impl;

import com.gmail.kaminski.viktar.shop.repository.DiscountRepository;
import com.gmail.kaminski.viktar.shop.repository.UserRepository;
import com.gmail.kaminski.viktar.shop.repository.model.Discount;
import com.gmail.kaminski.viktar.shop.repository.model.User;
import com.gmail.kaminski.viktar.shop.service.DiscountService;
import com.gmail.kaminski.viktar.shop.service.converter.DiscountConverter;
import com.gmail.kaminski.viktar.shop.service.exception.DateFormatException;
import com.gmail.kaminski.viktar.shop.service.model.DiscountDTO;
import com.gmail.kaminski.viktar.shop.service.model.NewDiscountDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private DiscountRepository discountRepository;
    private DiscountConverter discountConverter;
    private UserRepository userRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository,
                               DiscountConverter discountConverter,
                               UserRepository userRepository) {
        this.discountRepository = discountRepository;
        this.discountConverter = discountConverter;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void add(Long userId, NewDiscountDTO discountDTO) {
        Discount discount = discountConverter.toDiscount(discountDTO);
        User user = userRepository.findById(userId);
        discount.setUser(user);
        discountRepository.add(discount);
    }

    @Override
    @Transactional
    public List<DiscountDTO> findAllDiscountForUser(Long userId) {
        User user = userRepository.findById(userId);
        List<Discount> discounts = user.getDiscounts();
        List<DiscountDTO> discountDTOs = new ArrayList<>();
        for (Discount discount : discounts) {
            discountDTOs.add(discountConverter.toDiscountDTO(discount));
        }
        return discountDTOs;
    }

    @Override
    @Transactional
    public void delete(Long discountId) {
        Discount discount = discountRepository.findById(discountId);
        discountRepository.delete(discount);
    }
}
