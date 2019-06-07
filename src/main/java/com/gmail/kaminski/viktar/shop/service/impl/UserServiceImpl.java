package com.gmail.kaminski.viktar.shop.service.impl;

import com.gmail.kaminski.viktar.shop.repository.UserRepository;
import com.gmail.kaminski.viktar.shop.repository.model.User;
import com.gmail.kaminski.viktar.shop.service.UserService;
import com.gmail.kaminski.viktar.shop.service.converter.UserConverter;
import com.gmail.kaminski.viktar.shop.service.model.UserAuthorizedDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    @Transactional
    public UserAuthorizedDTO getByUsername(String username) {
        User user = userRepository.getByUsername(username);
        return userConverter.toAuthorizedDTO(user);
    }
}
