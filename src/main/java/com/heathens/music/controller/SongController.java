package com.heathens.music.controller;

import com.heathens.music.model.Song;
import com.heathens.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Song>> getAllSong() {
        List<Song> songs = this.songService.findAll();
        if(songs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
 }
