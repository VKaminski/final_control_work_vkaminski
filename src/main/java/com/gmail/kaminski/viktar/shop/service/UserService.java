package com.gmail.kaminski.viktar.shop.service;

import com.gmail.kaminski.viktar.shop.service.model.UserAuthorizedDTO;

public interface UserService {
    UserAuthorizedDTO getByUsername(String username);
}
