package com.MoovieMatcher.moovieMatcher.services;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.models.SavedMovie;
import com.MoovieMatcher.moovieMatcher.repositories.SavedMovieRepository;
import org.springframework.stereotype.Service;

@Service
public class SavedMovieService {

    private final SavedMovieRepository savedMovieRepository;

    public SavedMovieService(SavedMovieRepository savedMovieRepository) {
        this.savedMovieRepository = savedMovieRepository;
    }

    public saveMovie(SavedMovieRequestDto savedMovieRequestDto) {
        return this.savedMovieRepository.save(savedMovieRequestDto);
    }
}
