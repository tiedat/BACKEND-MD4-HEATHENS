package com.heathens.music.service;

import com.heathens.music.model.User;

public interface IUserService {
    ServiceResult findAll();
    ServiceResult findById(Long id);
    ServiceResult create(User user);
    ServiceResult update(User user);
    ServiceResult delete(Long id);

}
