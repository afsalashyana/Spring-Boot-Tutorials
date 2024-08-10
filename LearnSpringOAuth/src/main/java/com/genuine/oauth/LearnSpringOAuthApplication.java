package com.genuine.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class LearnSpringOAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringOAuthApplication.class, args);
    }

}
