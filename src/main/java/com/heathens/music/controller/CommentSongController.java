package com.heathens.music.controller;


import com.heathens.music.model.CommentSong;
import com.heathens.music.service.ICommentService;
import com.heathens.music.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/cmtsong")
public class CommentSongController {

    @Autowired
    @Qualifier("cmtSong")
    ICommentService<CommentSong> cmtSongService;

    /* ---------------- GET ALL CMTSONG ------------------------ */

    @GetMapping
    public ResponseEntity<ServiceResult> getAllCmtSong() {
        return new ResponseEntity<>(cmtSongService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET CMTSONG BY ID ------------------------ */

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getCmtSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cmtSongService.findById(id), HttpStatus.OK);
    }


    /* ---------------- DELETE CMTSONG ------------------------ */

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> deleteCmtSong(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cmtSongService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE CMTSONG ------------------------ */

    @PostMapping
    public ResponseEntity<ServiceResult> createCmtSong(@RequestBody CommentSong cmtSong) {
        return new ResponseEntity<>(cmtSongService.create(cmtSong), HttpStatus.OK);
    }

    /* ---------------- UPDATE CMTSONG ------------------------ */

    @PatchMapping
    public ResponseEntity<ServiceResult> updateCmtSong(@RequestBody CommentSong cmtSong) {
        return new ResponseEntity<>(cmtSongService.update(cmtSong), HttpStatus.OK);
    }

}
