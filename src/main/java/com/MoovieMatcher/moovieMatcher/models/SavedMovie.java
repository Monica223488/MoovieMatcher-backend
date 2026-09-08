package com.MoovieMatcher.moovieMatcher.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
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

    public SavedMovie(Long tmdbId, String title, String posterPath) {
        this.tmdbId = tmdbId;
        this.title = title;
        this.posterPath = posterPath;
    }

}
