package com.heathens.music.controller;

import com.heathens.music.model.Song;
import com.heathens.music.model.User;
import com.heathens.music.service.ISongService;
import com.heathens.music.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class SongController {

    @Autowired
    ISongService songService;

    /* ---------------- GET ALL SONG ------------------------ */

    @GetMapping("/songs")
    public ResponseEntity<ServiceResult> getAllSong() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET SONG BY ID ------------------------ */

    @GetMapping("/songs/{id}")
    public ResponseEntity<ServiceResult> getSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
    }

    /* ---------------- SEARCH SONG 10 BY NAME ------------------------ */

    @GetMapping("/songs/search")
    public ResponseEntity<ServiceResult> getTop10ByNameLike(@RequestParam("nameContains") String textSearch) {
        return new ResponseEntity<>(songService.findTop10ByNameContains(textSearch), HttpStatus.OK);
    }

    /* ---------------- GET ALL MY SONG ------------------------ */

    @GetMapping("/mysongs")
    public ResponseEntity<ServiceResult> getAllSongByUser(@RequestBody User user) {
        return new ResponseEntity<>(songService.findAllByUser(user), HttpStatus.OK);
    }


    /* ---------------- DELETE MY SONG ------------------------ */

    @DeleteMapping("/mysongs/{id}")
    public ResponseEntity<ServiceResult> deleteSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE MY SONG ------------------------ */

    @PostMapping("/mysongs")
    public ResponseEntity<ServiceResult> createSong(@RequestBody Song user) {
        return new ResponseEntity<>(songService.create(user), HttpStatus.OK);
    }

    /* ---------------- UPDATE MY SONG ------------------------ */

    @PatchMapping("/mysongs")
    public ResponseEntity<ServiceResult> updateSong(@RequestBody Song user) {
        return new ResponseEntity<>(songService.update(user), HttpStatus.OK);
    }

}
