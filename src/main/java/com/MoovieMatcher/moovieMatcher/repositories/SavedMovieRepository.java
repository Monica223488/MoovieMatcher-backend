package com.MoovieMatcher.moovieMatcher.repositories;

import com.MoovieMatcher.moovieMatcher.models.SavedMovie;
import com.MoovieMatcher.moovieMatcher.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SavedMovieRepository extends JpaRepository<SavedMovie, UUID> {
    List<SavedMovie> findAllByUser(User user);
    Optional<SavedMovie> findByIdAndUser(UUID id, User user);
}


