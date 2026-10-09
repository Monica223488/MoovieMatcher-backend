package com.MoovieMatcher.moovieMatcher.exceptions;

public class SavedMovieNotFoundException extends RuntimeException {
    public SavedMovieNotFoundException(String message) {
        super(message);
    }
}
