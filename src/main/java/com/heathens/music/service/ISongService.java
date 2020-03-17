package com.heathens.music.service;

import com.heathens.music.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    Optional<Song> findById(Long id);
}
