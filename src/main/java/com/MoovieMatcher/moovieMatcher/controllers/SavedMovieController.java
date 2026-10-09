package com.MoovieMatcher.moovieMatcher.controllers;

import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.SavedMovieResponseDto;
import com.MoovieMatcher.moovieMatcher.services.SavedMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class SavedMovieController {

    private final SavedMovieService savedMovieService;

    public SavedMovieController(SavedMovieService savedMovieService) {
        this.savedMovieService = savedMovieService;
    }

    @PostMapping("/saved-movies")
    public ResponseEntity<SavedMovieResponseDto> saveMovie(
            @RequestBody SavedMovieRequestDto savedMovieRequestDto){
        SavedMovieResponseDto savedMovie = savedMovieService.saveMovie(savedMovieRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @GetMapping("/saved-movies")
    public ResponseEntity<List<SavedMovieResponseDto>> getAllMovies(){
        return ResponseEntity.ok(savedMovieService.getAllMovies());
    }

    @DeleteMapping("/saved-movies/{id}")
    public ResponseEntity<SavedMovieResponseDto> deleteMovie(@PathVariable("id") UUID id){
        return ResponseEntity.ok(savedMovieService.deleteMovie(id));
    }
}
