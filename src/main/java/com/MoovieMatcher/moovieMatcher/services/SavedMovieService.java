package com.MoovieMatcher.moovieMatcher.services;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieResponseDto;
import com.MoovieMatcher.moovieMatcher.mappers.SavedMovieMapper;
import com.MoovieMatcher.moovieMatcher.models.SavedMovie;
import com.MoovieMatcher.moovieMatcher.repositories.SavedMovieRepository;
import org.springframework.stereotype.Service;

@Service
public class SavedMovieService {

    private final SavedMovieRepository savedMovieRepository;

    public SavedMovieService(SavedMovieRepository savedMovieRepository) {
        this.savedMovieRepository = savedMovieRepository;
    }

    public SavedMovieResponseDto saveMovie(SavedMovieRequestDto savedMovieRequestDto) {
        SavedMovie savedMovie = SavedMovieMapper.toEntity(savedMovieRequestDto);
        SavedMovie savedMovieResult = savedMovieRepository.save(savedMovie);
        return SavedMovieMapper.toResponseDto(savedMovie);
    }
}
