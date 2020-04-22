package com.heathens.music.controller;

import com.heathens.music.model.Song;
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
    public ResponseEntity<ServiceResult> getAllSongByUser(@RequestParam("username") String username) {
        return new ResponseEntity<>(songService.findAllSongByUsername(username), HttpStatus.OK);
    }


    /* ---------------- DELETE MY SONG ------------------------ */

    @DeleteMapping("/mysongs/{id}")
    public ResponseEntity<ServiceResult> deleteSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE MY SONG ------------------------ */

    @PostMapping("/mysongs")
    public ResponseEntity<ServiceResult> createSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.create(song), HttpStatus.OK);
    }

    /* ---------------- UPDATE MY SONG ------------------------ */

    @PatchMapping("/mysongs")
    public ResponseEntity<ServiceResult> updateSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.update(song), HttpStatus.OK);
    }

    @GetMapping("/songs/top20")
    public ResponseEntity<ServiceResult> findTop20Song() {
        return new ResponseEntity<>(songService.findTop20Song(), HttpStatus.OK);
    }

}
