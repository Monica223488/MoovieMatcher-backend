package com.MoovieMatcher.moovieMatcher.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
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

    public User(String email, String password, String name) {
        this.email = email;
        this.name = password;
        this.password = name;
    }

    @OneToMany(mappedBy = "user")
    private List<SavedMovie> savedMovies;

}
