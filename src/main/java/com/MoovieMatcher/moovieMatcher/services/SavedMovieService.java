package com.MoovieMatcher.moovieMatcher.services;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieResponseDto;
import com.MoovieMatcher.moovieMatcher.exceptions.SavedMovieNotFoundException;
import com.MoovieMatcher.moovieMatcher.exceptions.UserNotFoundException;
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

    private User getCurrentUser() {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Gebruiker niet gevonden."));
    }

    public SavedMovieResponseDto saveMovie(SavedMovieRequestDto savedMovieRequestDto) {

        SavedMovie savedMovie = SavedMovieMapper.toEntity(savedMovieRequestDto);

        User user = getCurrentUser();

        savedMovie.setUser(user);
        SavedMovie savedMovieResult = savedMovieRepository.save(savedMovie);

        return SavedMovieMapper.toResponseDto(savedMovieResult);
    }

    public List<SavedMovieResponseDto> getAllMovies() {

        User user = getCurrentUser();

        List<SavedMovie> savedMovies = savedMovieRepository.findAllByUser(user);
        List<SavedMovieResponseDto> savedMovieResponseDtos = new ArrayList<>();
        for (SavedMovie savedMovie : savedMovies) {
            savedMovieResponseDtos.add(SavedMovieMapper.toResponseDto(savedMovie));
        }
        return savedMovieResponseDtos;
    }

    public SavedMovieResponseDto deleteMovie(UUID id) {
        User user = getCurrentUser();
        SavedMovie savedMovie = savedMovieRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new SavedMovieNotFoundException("Movie not found"));
        savedMovieRepository.delete(savedMovie);
        SavedMovieResponseDto savedMovieResponseDto = SavedMovieMapper.toResponseDto(savedMovie);
        return savedMovieResponseDto;
    }
}
