package com.heathens.music.service.impl;

import com.heathens.music.model.Playlist;
import com.heathens.music.model.User;
import com.heathens.music.repository.IPlaylistRepo;
import com.heathens.music.repository.IUserRepo;
import com.heathens.music.service.IPlaylistService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlaylistServiceImpl implements IPlaylistService {
    @Autowired
    private IPlaylistRepo playlistRepo;


    @Autowired
    private IUserRepo userRepo;


    @Override
    public ServiceResult findAll() {
        ServiceResult sr = new ServiceResult();
        sr.setData(playlistRepo.findAll());
        return sr;
    }

    @Override
    public ServiceResult findAllPlaylistByUsername(String username) {
        ServiceResult sr = new ServiceResult();
        Optional<User> user = userRepo.findByUsernameIgnoreCase(username);
        if (!user.isPresent()) {
            sr.setMessage("User Not Found, No Playlist Found");
            return sr;
        } else {
            sr.setData(playlistRepo.findAllByUser(user));
        }
        return sr;
    }

    @Override
    public ServiceResult findTop10ByNameContains(String textSearch) {
        ServiceResult sr = new ServiceResult();
        List<Playlist> playlists = playlistRepo.findTop10ByNameContains(textSearch);
        if (playlists.isEmpty()) {
            sr.setMessage("No Playlist Match");
        }
        sr.setData(playlistRepo.findTop10ByNameContains(textSearch));
        return sr;
    }

    @Override
    public ServiceResult findById(Long id) {
        ServiceResult sr = new ServiceResult();
        Playlist playlist = playlistRepo.findById(id).orElse(null);
        if (playlist == null) {
            sr.setMessage("Playlist Not Found");
        }
        sr.setData(playlist);
        return sr;
    }

    @Override
    public ServiceResult create(Playlist playlist) {
        ServiceResult sr = new ServiceResult();
        sr.setData(playlistRepo.save(playlist));
        return sr;
    }

    @Override
    public ServiceResult update(Playlist playlist) {

        ServiceResult sr = new ServiceResult();
        if (!playlistRepo.findById(playlist.getId()).isPresent()) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Playlist Not Found");
        } else {
            sr.setData(playlistRepo.save(playlist));
        }
        return sr;
    }

    @Override
    public ServiceResult delete(Long id) {
        ServiceResult sr = new ServiceResult();
        Playlist playlist = playlistRepo.findById(id).orElse(null);
        if (playlist == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Playlist Not Found");
        } else {
            playlistRepo.delete(playlist);
        }
        return sr;
    }
}
