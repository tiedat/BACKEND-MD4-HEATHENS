package com.heathens.music.service.impl;

import com.heathens.music.model.Song;
import com.heathens.music.model.Tag;
import com.heathens.music.model.User;
import com.heathens.music.repository.ISongRepo;
import com.heathens.music.repository.ITagRepo;
import com.heathens.music.repository.IUserRepo;
import com.heathens.music.service.ISongService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepo songRepo;

    @Autowired
    private ITagRepo tagRepo;

    @Autowired
    private IUserRepo userRepo;


    @Override
    public ServiceResult findAll() {
        ServiceResult sr = new ServiceResult();
        sr.setData(songRepo.findAll());
        return sr;
    }

    @Override
    public ServiceResult findAllSongByUsername(String username) {
        ServiceResult sr = new ServiceResult();
        Optional<User> user = userRepo.findByUsernameIgnoreCase(username);
        if (!user.isPresent()) {
            sr.setMessage("User Not Found, No Song Found");
            return sr;
        } else {
            sr.setData(songRepo.findAllByUser(user));
        }
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
        Set<Tag> tags = song.getTags();

        for (Tag tag : tags) {
            Tag tagFind = tagRepo.findByNameTag(tag.getNameTag());
            if (tagFind == null) {
                Tag newTag = tagRepo.save(tag);  // create tag not exist
                tag.setId(newTag.getId()); // set id cho tag
            } else {
                tag.setId(tagFind.getId()); // set id cho tag
            }
        }

        ServiceResult sr = new ServiceResult();
        sr.setData(songRepo.save(song));
        return sr;
    }

    @Override
    public ServiceResult update(Song song) {
        Set<Tag> fixedTags = song.getTags(); // new tags and tags to delete
        Song songFind = songRepo.findById(song.getId()).get();

        for (Tag tag : fixedTags) {
            if (tag.getId() == null) {
                Tag tagFind = tagRepo.findByNameTag(tag.getNameTag());
                if (tagFind == null) {
                    Tag newTag = tagRepo.save(tag);  // create tag not exist
                    songFind.getTags().add(newTag); // add tag to tags(song)
                } else {
                    songFind.getTags().remove(tag); //remove tag
                }
            } else {

            }
        }
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
