package com.fundamentals.spring.fundamentalsJavaSpringBoot.service;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream().peek(user -> LOG.info("Inserted user: " + user))
                .forEach(user -> userRepository.save(user));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
