package com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void delete(Long id) {
        userService.delete(id);
    }
}
