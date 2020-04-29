package com.heathens.music.controller;

import com.heathens.music.model.CommentPlaylist;
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
@RequestMapping("/api/cmtpls")
public class CommentPlaylistController {

    @Autowired
    @Qualifier("cmtPlaylist")
    ICommentService<CommentPlaylist> cmtPlaylistService;


    /* ---------------- GET ALL CMTPLAYLIST  ------------------------ */

    @GetMapping
    public ResponseEntity<ServiceResult> getAllCmtPlaylist() {
        return new ResponseEntity<>(cmtPlaylistService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET CMTPLAYLIST BY ID ------------------------ */

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getCmtPlaylist(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cmtPlaylistService.findById(id), HttpStatus.OK);
    }


    /* ---------------- DELETE CMTPLAYLIST ------------------------ */

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> deleteCmtPlaylist(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cmtPlaylistService.delete(id), HttpStatus.OK);
    }

    /* ---------------- CREATE CMTPLAYLIST ------------------------ */

    @PostMapping
    public ResponseEntity<ServiceResult> createCmtPlaylist(@RequestBody CommentPlaylist cmtPlaylist) {
        return new ResponseEntity<>(cmtPlaylistService.create(cmtPlaylist), HttpStatus.OK);
    }

    /* ---------------- UPDATE CMTPLAYLIST ------------------------ */

    @PatchMapping
    public ResponseEntity<ServiceResult> updateCmtPlaylist(@RequestBody CommentPlaylist cmtPlaylist) {
        return new ResponseEntity<>(cmtPlaylistService.update(cmtPlaylist), HttpStatus.OK);
    }

}
