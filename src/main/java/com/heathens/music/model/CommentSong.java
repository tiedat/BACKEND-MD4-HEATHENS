package com.heathens.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "commentsong")
public class CommentSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "song_id", updatable = false)
    private Song song;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

}
