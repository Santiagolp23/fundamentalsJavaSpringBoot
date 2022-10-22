package com.fundamentals.spring.fundamentalsJavaSpringBoot.configuration;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.service.UserService;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.CreateUser;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.GetUser;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.GetUserImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesBeanConfiguration {

    @Bean
    public GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }

}
