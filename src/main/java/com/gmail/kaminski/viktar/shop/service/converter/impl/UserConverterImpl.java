package com.gmail.kaminski.viktar.shop.service.converter.impl;

import com.gmail.kaminski.viktar.shop.repository.model.User;
import com.gmail.kaminski.viktar.shop.service.converter.UserConverter;
import com.gmail.kaminski.viktar.shop.service.model.UserAuthorizedDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserAuthorizedDTO toAuthorizedDTO(User user) {
        UserAuthorizedDTO authorizedUser = new UserAuthorizedDTO();
        authorizedUser.setId(user.getId());
        authorizedUser.setUsername(user.getUsername());
        authorizedUser.setPassword(user.getPassword());
        authorizedUser.setRole(user.getRole());
        return authorizedUser;
    }
}
