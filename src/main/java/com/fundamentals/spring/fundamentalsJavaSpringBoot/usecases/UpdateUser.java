package com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
