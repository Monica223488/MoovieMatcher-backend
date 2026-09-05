package com.MoovieMatcher.moovieMatcher.mappers;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieResponseDto;
import com.MoovieMatcher.moovieMatcher.models.SavedMovie;

public class SavedMovieMapper {

    public static SavedMovie toEntity(SavedMovieRequestDto savedMovieRequestDto) {
        SavedMovie savedMovie = new SavedMovie(
                savedMovieRequestDto.,
                savedMovieRequestDto.
        );
        return savedMovie;
    }

    public static SavedMovieResponseDto toResponseDto (SavedMovie savedMovie){
        SavedMovieResponseDto appointmentResponseDto = new SavedMovieResponseDto();
        savedMovieResponseDto.id = savedMovie.getId();
        savedMovieResponseDto. = savedMovie.get();
        savedMovieResponseDto. = savedMovie.get();
        return savedMovieResponseDto;
    }
}
