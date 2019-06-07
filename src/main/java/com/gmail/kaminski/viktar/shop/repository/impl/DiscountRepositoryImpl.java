package com.gmail.kaminski.viktar.shop.repository.impl;

import com.gmail.kaminski.viktar.shop.repository.DiscountRepository;
import com.gmail.kaminski.viktar.shop.repository.model.Discount;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountRepositoryImpl extends GenericRepositoryImpl<Long, Discount> implements DiscountRepository {
}
