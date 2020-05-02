package com.heathens.music.service.impl;

import com.heathens.music.model.CommentSong;
import com.heathens.music.model.Song;
import com.heathens.music.repository.ICommentSongRepo;
import com.heathens.music.repository.ISongRepo;
import com.heathens.music.service.ICommentService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("cmtSong")
public class CommentSongServiceImpl implements ICommentService<CommentSong> {

    @Autowired
    ICommentSongRepo commentSongRepo;

    @Autowired
    ISongRepo songRepo;

    @Override
    public ServiceResult findAll(Long songId) {
        ServiceResult sr = new ServiceResult();
        Optional<Song> song = songRepo.findById(songId);
        if (song.isPresent()) {
            Iterable<CommentSong> commentSongs = commentSongRepo.findAllBySong(song);
            sr.setData(commentSongs);
        } else {
            sr.setMessage("Song Not Found");
        }
        return sr;
    }

    @Override
    public ServiceResult findById(Long id) {
        ServiceResult sr = new ServiceResult();
        CommentSong commentSong = commentSongRepo.findById(id).orElse(null);
        if (commentSong == null) {
            sr.setMessage("CommentSong Not Found");
        }
        sr.setData(commentSong);
        return sr;
    }

    @Override
    public ServiceResult create(CommentSong commentSong) {
        ServiceResult sr = new ServiceResult();
        sr.setData(commentSongRepo.save(commentSong));
        return sr;
    }

    @Override
    public ServiceResult update(CommentSong commentSong) {
        ServiceResult sr = new ServiceResult();
        sr.setData(commentSongRepo.save(commentSong));
        return sr;
    }

    @Override
    public ServiceResult delete(Long id) {
        ServiceResult sr = new ServiceResult();
        CommentSong commentSong = commentSongRepo.findById(id).orElse(null);
        if (commentSong == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("CommentSong Not Found");
        } else {
            commentSongRepo.delete(commentSong);
        }
        return sr;
    }
}
