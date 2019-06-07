package com.gmail.kaminski.viktar.shop.service.impl;

import com.gmail.kaminski.viktar.shop.service.UserService;
import com.gmail.kaminski.viktar.shop.service.model.AppUserPrincipal;
import com.gmail.kaminski.viktar.shop.service.model.UserAuthorizedDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthorizedDTO authorizedUserDTO = userService.getByUsername(username);
        if (authorizedUserDTO == null) {
            throw new UsernameNotFoundException("User is not found!");
        }
        return new AppUserPrincipal(authorizedUserDTO);
    }
}
