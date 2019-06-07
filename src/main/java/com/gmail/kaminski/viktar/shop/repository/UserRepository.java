package com.gmail.kaminski.viktar.shop.repository;

import com.gmail.kaminski.viktar.shop.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {
    User getByUsername(String username);
}
