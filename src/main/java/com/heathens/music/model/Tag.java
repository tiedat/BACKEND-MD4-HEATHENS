package com.heathens.music.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTag;

    @ManyToMany(mappedBy = "tagList")
    private List<Song> userList;
}
