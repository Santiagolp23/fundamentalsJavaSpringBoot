package com.fundamentals.spring.fundamentalsJavaSpringBoot.repository;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
