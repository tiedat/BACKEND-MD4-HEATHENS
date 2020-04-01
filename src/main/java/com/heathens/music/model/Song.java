package com.heathens.music.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<Tag> tags = new ArrayList<>();


    @ManyToOne
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "user_id")
    private User user;


}
