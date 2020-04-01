package com.heathens.music.service;

import com.heathens.music.model.Song;
import com.heathens.music.model.User;

public interface ISongService {
    ServiceResult findAll();
    ServiceResult findById(Long id);
    ServiceResult create(Song song);
    ServiceResult update(Song song);
    ServiceResult delete(Long id);
    ServiceResult findAllByUser(User user);
    ServiceResult findTop10ByNameContains(String textSearch);


}
