package com.gmail.kaminski.viktar.shop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.gmail.kaminski.viktar.shop"})
@EntityScan("com.gmail.kaminski.viktar.shop.repository")
public class JDShop {
    public static void main(String[] args) {
        SpringApplication.run(JDShop.class, args);
    }
}
