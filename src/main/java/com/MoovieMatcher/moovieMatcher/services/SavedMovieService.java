package com.MoovieMatcher.moovieMatcher.services;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieResponseDto;
import com.MoovieMatcher.moovieMatcher.mappers.SavedMovieMapper;
import com.MoovieMatcher.moovieMatcher.models.SavedMovie;
import com.MoovieMatcher.moovieMatcher.models.User;
import com.MoovieMatcher.moovieMatcher.repositories.SavedMovieRepository;
import com.MoovieMatcher.moovieMatcher.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SavedMovieService {

    private final SavedMovieRepository savedMovieRepository;
    private final UserRepository userRepository;

    public SavedMovieService(SavedMovieRepository savedMovieRepository, UserRepository userRepository) {
        this.savedMovieRepository = savedMovieRepository;
        this.userRepository = userRepository;
    }

    public SavedMovieResponseDto saveMovie(SavedMovieRequestDto savedMovieRequestDto) {

        SavedMovie savedMovie = SavedMovieMapper.toEntity(savedMovieRequestDto);
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        savedMovie.setUser(user);
        SavedMovie savedMovieResult = savedMovieRepository.save(savedMovie);

        return SavedMovieMapper.toResponseDto(savedMovieResult);
    }

    public List<SavedMovieResponseDto> getAllMovies() {
        List<SavedMovie> savedMovies = savedMovieRepository.findAll();
        List<SavedMovieResponseDto> savedMovieResponseDtos = new ArrayList<>();
        for (SavedMovie savedMovie : savedMovies) {
            savedMovieResponseDtos.add(SavedMovieMapper.toResponseDto(savedMovie));
        }
        return savedMovieResponseDtos;
    }

    public SavedMovieResponseDto deleteMovie(UUID id) {
        SavedMovie savedMovie = savedMovieRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Movie not found"));
        savedMovieRepository.delete(savedMovie);
        SavedMovieResponseDto savedMovieResponseDto = SavedMovieMapper.toResponseDto(savedMovie);
        return savedMovieResponseDto;
    }
}
