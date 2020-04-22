package com.heathens.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "commentplaylist")
public class CommentPlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "playlist_id", updatable = false)
    private Playlist playlist;

    @ManyToOne
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;
}
