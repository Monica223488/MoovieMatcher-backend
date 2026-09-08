package com.MoovieMatcher.moovieMatcher.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SavedMovieResponseDto {
    private UUID id;
    private Long tmdbId;
    private String title;
    private String posterPath;
}
