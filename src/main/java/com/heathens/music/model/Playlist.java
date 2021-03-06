package com.heathens.music.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String description;

    @Column
    private Long numberOfPlays = 0L;

    @Column
    private String image;

    @Column(updatable = false)
    @JsonIgnore
    private LocalDateTime initTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    @Getter(AccessLevel.NONE)
    private User user;

    @ManyToMany
    private List<Song> songs;


}
