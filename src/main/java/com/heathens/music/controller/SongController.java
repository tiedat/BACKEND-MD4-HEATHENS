package com.heathens.music.controller;

import com.heathens.music.model.Song;
import com.heathens.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin("*")
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    ISongService songService;

    @GetMapping("")
    public ResponseEntity<List<Song>> getAllSong() {
        List<Song> songs = songService.findAll();
        if (songs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Song>> getSong(@PathVariable("id") Long id) {
        try {
            Optional<Song> song = songService.findById(id);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
