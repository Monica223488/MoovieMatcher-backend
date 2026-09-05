package com.MoovieMatcher.moovieMatcher.controllers;

import com.MoovieMatcher.moovieMatcher.services.SavedMovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SavedMovieController {

    private final SavedMovieService savedMovieService;

    public SavedMovieController(SavedMovieService savedMovieService) {
        this.savedMovieService = savedMovieService;
    }
}
