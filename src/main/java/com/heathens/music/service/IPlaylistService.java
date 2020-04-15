package com.heathens.music.service;


import com.heathens.music.model.Playlist;
import com.heathens.music.model.Song;

public interface IPlaylistService {
    ServiceResult findAll();
    ServiceResult findById(Long id);
    ServiceResult create(Playlist playlist);
    ServiceResult update(Playlist playlist);
    ServiceResult delete(Long id);
    ServiceResult findAllPlaylistByUsername(String username);
    ServiceResult findTop10ByNameContains(String textSearch);
    ServiceResult addSongToPlaylist(Song song);
    ServiceResult removeSongFromPlaylist(Song song);
}
