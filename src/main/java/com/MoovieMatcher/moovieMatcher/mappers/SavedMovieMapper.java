package com.MoovieMatcher.moovieMatcher.mappers;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieResponseDto;
import com.MoovieMatcher.moovieMatcher.models.SavedMovie;

public class SavedMovieMapper {

    public static SavedMovie toEntity(SavedMovieRequestDto savedMovieRequestDto) {
        SavedMovie savedMovie = new SavedMovie(
                savedMovieRequestDto.getTmdbId(),
                savedMovieRequestDto.getTitle(),
                savedMovieRequestDto.getPosterPath()
        );
        return savedMovie;
    }

    public static SavedMovieResponseDto toResponseDto (SavedMovie savedMovie){
        SavedMovieResponseDto savedMovieResponseDto = new SavedMovieResponseDto();
        savedMovieResponseDto.setId(savedMovie.getId());
        savedMovieResponseDto.setTmdbId(savedMovie.getTmdbId());
        savedMovieResponseDto.setTitle(savedMovie.getTitle());
        savedMovieResponseDto.setPosterPath(savedMovie.getPosterPath());
        return savedMovieResponseDto;
    }
}
