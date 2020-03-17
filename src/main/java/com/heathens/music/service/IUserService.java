package com.heathens.music.service;

import com.heathens.music.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findByUsername(String username);

}
