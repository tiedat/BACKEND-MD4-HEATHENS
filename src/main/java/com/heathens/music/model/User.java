package com.heathens.music.model;


import com.heathens.music.model.enumric.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private LocalDate dayOfBirth;

    @Column(unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Playlist> playlistList;

    @OneToMany(mappedBy = "user")
    private List<Song> songList;

}
