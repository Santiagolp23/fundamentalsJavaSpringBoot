package com.fundamentals.spring.fundamentalsJavaSpringBoot.controller;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.CreateUser;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.DeleteUser;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.GetUser;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.usecases.UpdateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //get, get, delete, update

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        deleteUser.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> editUser(@RequestBody User newUser,@PathVariable Long id) {
        return new ResponseEntity<>(updateUser.update(newUser ,id),HttpStatus.OK);
    }





}
