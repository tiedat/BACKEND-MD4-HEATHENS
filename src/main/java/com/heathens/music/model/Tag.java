package com.heathens.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameTag;

    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private List<Song> songList = new ArrayList<>();

}
