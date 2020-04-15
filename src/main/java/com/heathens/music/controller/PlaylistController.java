package com.heathens.music.controller;


import com.heathens.music.model.Playlist;
import com.heathens.music.service.IPlaylistService;
import com.heathens.music.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    IPlaylistService playlistService;

    /* ---------------- GET ALL PLAYLIST ------------------------ */

    @GetMapping("/playlists")
    public ResponseEntity<ServiceResult> getAllPlaylist() {
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET PLAYLIST BY ID ------------------------ */

    @GetMapping("/playlists/{id}")
    public ResponseEntity<ServiceResult> getPlaylist(@PathVariable("id") Long id) {
        return new ResponseEntity<>(playlistService.findById(id), HttpStatus.OK);
    }

    /* ---------------- SEARCH PLAYLIST 10 BY NAME ------------------------ */

    @GetMapping("/playlists/search")
    public ResponseEntity<ServiceResult> getTop10ByNameLike(@RequestParam("nameContains") String textSearch) {
        return new ResponseEntity<>(playlistService.findTop10ByNameContains(textSearch), HttpStatus.OK);
    }

    /* ---------------- GET ALL MY PLAYLIST ------------------------ */

    @GetMapping("/myplaylists")
    public ResponseEntity<ServiceResult> getAllPlaylistByUser(@RequestParam("username") String username) {
        return new ResponseEntity<>(playlistService.findAllPlaylistByUsername(username), HttpStatus.OK);
    }


    /* ---------------- DELETE MY PLAYLIST ------------------------ */

    @DeleteMapping("/myplaylists/{id}")
    public ResponseEntity<ServiceResult> deletePlaylist(@PathVariable("id") Long id) {
        return new ResponseEntity<>(playlistService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE MY PLAYLIST ------------------------ */

    @PostMapping("/myplaylists")
    public ResponseEntity<ServiceResult> createPlaylist(@RequestBody Playlist user) {
        return new ResponseEntity<>(playlistService.create(user), HttpStatus.OK);
    }

    /* ---------------- UPDATE MY PLAYLIST ------------------------ */

    @PatchMapping("/myplaylists")
    public ResponseEntity<ServiceResult> updatePlaylist(@RequestBody Playlist user) {
        return new ResponseEntity<>(playlistService.update(user), HttpStatus.OK);
    }
}
