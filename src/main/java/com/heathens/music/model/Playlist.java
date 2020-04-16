package com.heathens.music.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long numberOfPlays;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    @Getter(AccessLevel.NONE)
    private User user;

    @ManyToMany
    private List<Song> songs;

    @OneToMany
    private List<CommentPlaylist> cmtPlaylists = new ArrayList<>();

}
