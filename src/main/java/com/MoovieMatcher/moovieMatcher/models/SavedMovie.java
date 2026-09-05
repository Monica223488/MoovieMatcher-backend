package com.MoovieMatcher.moovieMatcher.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class SavedMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Setter
    private Long tmdbId;
    @Setter
    private String title;
    @Setter
    private String posterPath;

    @ManyToOne
    private User user;

    @PrePersist
    public void generateId(){
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
