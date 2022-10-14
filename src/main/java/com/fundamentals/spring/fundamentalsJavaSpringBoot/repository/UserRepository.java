package com.fundamentals.spring.fundamentalsJavaSpringBoot.repository;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    List<User> findByNameOrderByNameAsc(String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);
}
