package com.MoovieMatcher.moovieMatcher.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Setter
    private String email;
    @Setter
    private String password;
    @Setter
    private String name;

    @OneToMany(mappedBy = "user")
    private List<SavedMovie> savedMovies;

}
