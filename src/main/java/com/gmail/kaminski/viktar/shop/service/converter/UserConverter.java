package com.gmail.kaminski.viktar.shop.service.converter;

import com.gmail.kaminski.viktar.shop.repository.model.User;
import com.gmail.kaminski.viktar.shop.service.model.UserAuthorizedDTO;

public interface UserConverter {
    UserAuthorizedDTO toAuthorizedDTO(User user);
}
