package com.heathens.music.service.impl;

import com.heathens.music.model.User;
import com.heathens.music.repository.IUserRepository;
import com.heathens.music.service.IUserService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepo;

    @Autowired
    private ServiceResult sr;

    @Override
    public ServiceResult findAll() {
        sr.setData(userRepo.findAll());
        return sr;
    }

    @Override
    public ServiceResult findById(Long id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            sr.setMessage("User Not Found");
        }
        sr.setData(user);
        return sr;
    }

    @Override
    public ServiceResult create(User user) {
        sr.setData(userRepo.save(user));
        return sr;
    }

    @Override
    public ServiceResult update(User user) {
        if (!userRepo.findById(user.getId()).isPresent()) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("User Not Found");
        } else {
            sr.setData(userRepo.save(user));
        }
        return sr;
    }

    @Override
    public ServiceResult delete(Long id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("User Not Found");
        } else {
            userRepo.delete(user);
        }
        return sr;
    }
}
