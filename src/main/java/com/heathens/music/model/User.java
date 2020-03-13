package com.heathens.music.model;


import com.heathens.music.model.enumric.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    private String userName;

    @Column
    private String password;

    @Column
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private Date dayOfBirth;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlistList;

    @OneToMany(mappedBy = "user")
    private List<Song> songList;

}
