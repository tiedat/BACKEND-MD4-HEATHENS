package com.heathens.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

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
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

}
