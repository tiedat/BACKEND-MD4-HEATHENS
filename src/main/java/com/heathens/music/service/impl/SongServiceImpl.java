package com.heathens.music.service.impl;

import com.heathens.music.model.Song;
import com.heathens.music.model.Tag;
import com.heathens.music.model.User;
import com.heathens.music.repository.ISongRepo;
import com.heathens.music.repository.ITagRepo;
import com.heathens.music.service.ISongService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepo songRepo;

    @Autowired
    private ITagRepo tagRepo;


    @Override
    public ServiceResult findAll() {
        ServiceResult sr = new ServiceResult();
        sr.setData(songRepo.findAll());
        return sr;
    }

    @Override
    public ServiceResult findAllByUser(User user) {
        ServiceResult sr = new ServiceResult();
        sr.setData(songRepo.findAllByUser(user));
        return sr;
    }

    @Override
    public ServiceResult findTop10ByNameContains(String textSearch) {
        ServiceResult sr = new ServiceResult();
        List<Song> songs = songRepo.findTop10ByNameContains(textSearch);
        if (songs.isEmpty()) {
            sr.setMessage("No Song Match");
        }
        sr.setData(songRepo.findTop10ByNameContains(textSearch));
        return sr;
    }

    @Override
    public ServiceResult findById(Long id) {
        ServiceResult sr = new ServiceResult();
        Song song = songRepo.findById(id).orElse(null);
        if (song == null) {
            sr.setMessage("Song Not Found");
        }
        sr.setData(song);
        return sr;
    }

    @Override
    public ServiceResult create(Song song) {
        List<Tag> tags = song.getTags();
        for (Tag tag : tags) {
            if (!tagRepo.findByNameTag(tag.getNameTag()).isPresent()) {
                tagRepo.save(tag);
            }
        } // create tag not exist

        ServiceResult sr = new ServiceResult();
        sr.setData(songRepo.save(song));
        return sr;
    }

    @Override
    public ServiceResult update(Song song) {
//        List<Tag> tags = song.getTags();
//        for (Tag tag : tags) {
//            if (!tagRepo.findByNameTag(tag.getNameTag()).isPresent()) {
//                tagRepo.save(tag);
//            } else
//        }
        ServiceResult sr = new ServiceResult();
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
        ServiceResult sr = new ServiceResult();
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
