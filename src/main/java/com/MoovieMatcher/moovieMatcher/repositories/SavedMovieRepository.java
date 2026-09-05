package com.MoovieMatcher.moovieMatcher.repositories;

import com.MoovieMatcher.moovieMatcher.models.SavedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SavedMovieRepository extends JpaRepository<SavedMovie, UUID> {
}


