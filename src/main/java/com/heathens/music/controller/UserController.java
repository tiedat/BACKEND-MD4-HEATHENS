package com.heathens.music.controller;


import com.heathens.music.model.User;
import com.heathens.music.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> getSong(@PathVariable("username") String username) {
        try {
            Optional<User> song = userService.findByUsername(username);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
