package com.heathens.music.model;


import com.heathens.music.model.enumric.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
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

    @Column(unique = true)
    private String phoneNumber;


}
