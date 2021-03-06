package com.heathens.music.service;


import com.heathens.music.model.Playlist;

public interface IPlaylistService {
    ServiceResult findAll();
    ServiceResult findById(Long id);
    ServiceResult create(Playlist playlist);
    ServiceResult update(Playlist playlist);
    ServiceResult delete(Long id);
    ServiceResult findAllPlaylistByUsername(String username);
    ServiceResult findTop10ByNameContains(String textSearch);
}
