package com.heathens.music.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String descriptionSong;

    @Column
    private String fileMp3;

    @Column
    private String image;

    @Column
    private Long numberOfPlays;

    @ManyToMany
    @JoinTable(name = "song_tag",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();


    @ManyToOne
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @OneToMany
    private List<CommentSong> cmtSongs = new ArrayList<>();

}
