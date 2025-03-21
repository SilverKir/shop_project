package com.example.userData.controllers;

import com.example.userData.model.User;
import com.example.userData.services.UserService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    public final UserService userService;

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        meterRegistry.counter("requests_to_users").increment();
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        if (userService.getUserById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        meterRegistry.counter("count_added_users").increment();
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        if (userService.getUserById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
