package com.heathens.music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String description;

    @Column
    private String fileMp3;

    @Column
    private String image;

    @Column
    private Long numberOfPlays = 0L;

    @Column(updatable = false)
    private LocalDateTime initTime = LocalDateTime.now();

    @ManyToMany
    @JoinTable(name = "song_tag",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();


    @ManyToOne
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;


}
