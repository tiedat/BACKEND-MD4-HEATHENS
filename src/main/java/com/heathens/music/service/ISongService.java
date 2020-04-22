package com.heathens.music.service;

import com.heathens.music.model.Song;

public interface ISongService {
    ServiceResult findAll();
    ServiceResult findById(Long id);
    ServiceResult create(Song song);
    ServiceResult update(Song song);
    ServiceResult delete(Long id);
    ServiceResult findAllSongByUsername(String username);
    ServiceResult findTop10ByNameContains(String textSearch);

    ServiceResult findTop20Song();
    ServiceResult find20NewestSong();

}
