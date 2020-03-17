package com.heathens.music.service.impl;

import com.heathens.music.model.Song;
import com.heathens.music.repository.ISongRepository;
import com.heathens.music.service.ISongService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository songRepo;

    @Autowired
    private ServiceResult sr;

    @Override
    public ServiceResult findAll() {
        sr.setData(songRepo.findAll());
        return sr;
    }

    @Override
    public ServiceResult findById(Long id) {
        Song song = songRepo.findById(id).orElse(null);
        if (song == null) {
            sr.setMessage("Song Not Found");
        }
        sr.setData(song);
        return sr;
    }

    @Override
    public ServiceResult create(Song song) {
        sr.setData(songRepo.save(song));
        return sr;
    }

    @Override
    public ServiceResult update(Song song) {
        if (!songRepo.findById(song.getId()).isPresent()) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Song Not Found");
        } else {
            sr.setData(songRepo.save(song));
        }
        return sr;
    }

    @Override
    public ServiceResult delete(Long id) {
        Song song = songRepo.findById(id).orElse(null);
        if (song == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("Song Not Found");
        } else {
            songRepo.delete(song);
        }
        return sr;
    }
}
