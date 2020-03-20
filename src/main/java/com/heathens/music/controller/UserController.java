package com.heathens.music.controller;


import com.heathens.music.model.User;
import com.heathens.music.service.IUserService;
import com.heathens.music.service.ServiceResult;
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

    /* ---------------- GET ALL USER ------------------------ */

    @GetMapping
    public ResponseEntity<ServiceResult> getAllUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET USER BY ID ------------------------ */

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    /* ---------------- DELETE USER ------------------------ */

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE USER ------------------------ */

    @PostMapping
    public ResponseEntity<ServiceResult> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    /* ---------------- UPDATE USER ------------------------ */

    @PatchMapping
    public ResponseEntity<ServiceResult> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

}
