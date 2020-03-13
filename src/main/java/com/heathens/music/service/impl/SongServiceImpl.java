package com.heathens.music.service.impl;

import com.heathens.music.model.Song;
import com.heathens.music.repository.ISongRepository;
import com.heathens.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
