package com.fundamentals.spring.fundamentalsJavaSpringBoot.repository;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
