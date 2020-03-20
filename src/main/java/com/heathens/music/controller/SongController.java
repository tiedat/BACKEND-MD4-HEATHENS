package com.heathens.music.controller;

import com.heathens.music.model.Song;
import com.heathens.music.service.ISongService;
import com.heathens.music.service.ServiceResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("*")
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    ISongService songService;

    /* ---------------- GET ALL SONG ------------------------ */

    @GetMapping
    public ResponseEntity<ServiceResult> getAllSong() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET SONG BY ID ------------------------ */

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
    }

    /* ---------------- DELETE SONG ------------------------ */

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> deleteSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE SONG ------------------------ */

    @PostMapping
    public ResponseEntity<ServiceResult> createSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.create(song), HttpStatus.OK);
    }

    /* ---------------- UPDATE SONG ------------------------ */

    @PatchMapping
    public ResponseEntity<ServiceResult> updateSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.update(song), HttpStatus.OK);
    }

}
