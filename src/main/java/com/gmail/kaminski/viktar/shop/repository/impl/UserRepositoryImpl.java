package com.gmail.kaminski.viktar.shop.repository.impl;

import com.gmail.kaminski.viktar.shop.repository.UserRepository;
import com.gmail.kaminski.viktar.shop.repository.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {

    @Override
    public User getByUsername(String username) {
        String hqlRequest = "select U from User U where U.username = :username";
        Query query = entityManager.createQuery(hqlRequest);
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
