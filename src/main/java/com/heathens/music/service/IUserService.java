package com.heathens.music.service;

import com.heathens.music.model.User;

public interface IUserService {
    ServiceResult findByUsernameIgnoreCase(String username);
    ServiceResult create(User user);
    ServiceResult update(User user);
    ServiceResult delete(Long id);

}
