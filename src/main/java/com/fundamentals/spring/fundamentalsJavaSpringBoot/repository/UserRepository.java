package com.fundamentals.spring.fundamentalsJavaSpringBoot.repository;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.dto.UserDTO;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    List<User> findByNameOrderByNameAsc(String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate initial, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    List<User> findByNameContainingAndBirthDateBetween(String name, LocalDate init, LocalDate end);

    @Query("SELECT new com.fundamentals.spring.fundamentalsJavaSpringBoot.dto.UserDTO(u.id, u.name, u.birthDate)"
            + " FROM User u "
            + "WHERE u.birthDate=:dateParameter "
            + "and u.email=:emailParameter")
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("dateParameter") LocalDate date, @Param("emailParameter") String email);}
