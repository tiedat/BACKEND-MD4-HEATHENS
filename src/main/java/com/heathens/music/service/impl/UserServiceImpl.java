package com.heathens.music.service.impl;

import com.heathens.music.model.User;
import com.heathens.music.repository.IUserRepo;
import com.heathens.music.service.IUserService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepo userRepo;

    @Override
    public ServiceResult findByUsernameIgnoreCase(String username) {
        ServiceResult sr = new ServiceResult();
        Optional<User> user = userRepo.findByUsernameIgnoreCase(username);
        if (!user.isPresent()) {
            sr.setMessage("User Not Found");
        }
        sr.setData(user);
        return sr;
    }

    @Override
    public ServiceResult create(User user) {
        ServiceResult sr = new ServiceResult();

        if (user.getUsername() == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Username Not Null");
            return sr;
        }

        Optional<User> userFind = userRepo.findByUsernameIgnoreCase(user.getUsername());

        if (userFind.isPresent()) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Username exist");
            return sr;
        }

        sr.setData(userRepo.save(user));

        return sr;
    }

    @Override
    public ServiceResult update(User user) {
        ServiceResult sr = new ServiceResult();

        Optional<User> userFound = userRepo.findById(user.getId());

        if (user.getUsername() == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Username Not Null");
            return sr;
        }

        if (!userFound.isPresent()) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("User Not Found");
            return sr;
        }

        String usernameFound = userFound.get().getUsername().toUpperCase();
        String usernameNew = user.getUsername().toUpperCase();
        if (!usernameFound.equals(usernameNew)
                && userRepo.findByUsernameIgnoreCase(user.getUsername()) != null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Username exist");
            return sr;
        }

        sr.setData(userRepo.save(user));

        return sr;
    }

    @Override
    public ServiceResult delete(Long id) {
        ServiceResult sr = new ServiceResult();
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
