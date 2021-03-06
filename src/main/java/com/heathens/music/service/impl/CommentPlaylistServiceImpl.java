package com.heathens.music.service.impl;

import com.heathens.music.model.CommentPlaylist;
import com.heathens.music.model.CommentSong;
import com.heathens.music.model.Playlist;
import com.heathens.music.repository.ICommentPlaylistRepo;
import com.heathens.music.repository.IPlaylistRepo;
import com.heathens.music.service.ICommentService;
import com.heathens.music.service.ServiceResult;
import com.heathens.music.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("cmtPlaylist")
public class CommentPlaylistServiceImpl implements ICommentService<CommentPlaylist> {

    @Autowired
    ICommentPlaylistRepo commentPlaylistRepo;

    @Autowired
    IPlaylistRepo playlistRepo;

    @Override
    public ServiceResult findAll(Long playlistId) {
        ServiceResult sr = new ServiceResult();
        Optional<Playlist> playlist = playlistRepo.findById(playlistId);
        if (playlist.isPresent()) {
            Iterable<CommentSong> commentSongs = commentPlaylistRepo.findAllByPlaylist(playlist);
            sr.setData(commentSongs);
        } else {
            sr.setMessage("Song Not Found");
        }
        return sr;
    }

    @Override
    public ServiceResult findById(Long id) {
        ServiceResult sr = new ServiceResult();
        CommentPlaylist commentPlaylist = commentPlaylistRepo.findById(id).orElse(null);
        if (commentPlaylist == null) {
            sr.setMessage("CommentPlaylist Not Found");
        }
        sr.setData(commentPlaylist);
        return sr;
    }

    @Override
    public ServiceResult create(CommentPlaylist commentPlaylist) {
        ServiceResult sr = new ServiceResult();
        sr.setData(commentPlaylistRepo.save(commentPlaylist));
        return sr;
    }

    @Override
    public ServiceResult update(CommentPlaylist commentPlaylist) {
        ServiceResult sr = new ServiceResult();
        sr.setData(commentPlaylistRepo.save(commentPlaylist));
        return sr;
    }

    @Override
    public ServiceResult delete(Long id) {
        ServiceResult sr = new ServiceResult();
        CommentPlaylist commentPlaylist = commentPlaylistRepo.findById(id).orElse(null);
        if (commentPlaylist == null) {
            sr.setStatus(StatusService.FAILED);
            sr.setMessage("CommentPlaylist Not Found");
        } else {
            commentPlaylistRepo.delete(commentPlaylist);
        }
        return sr;
    }
}
