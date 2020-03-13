package com.heathens.music.service;

import com.heathens.music.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
}
