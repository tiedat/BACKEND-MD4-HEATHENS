package com.heathens.music.service;

import com.heathens.music.model.Song;

import java.net.ServerSocket;
import java.util.List;
import java.util.Optional;

public interface ISongService {
    ServiceResult findAll();
    ServiceResult findById(Long id);
    ServiceResult create(Song song);
    ServiceResult update(Song song);
    ServiceResult delete(Long id);

}
