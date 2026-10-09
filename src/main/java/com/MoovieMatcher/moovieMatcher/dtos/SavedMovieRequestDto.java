package com.MoovieMatcher.moovieMatcher.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavedMovieRequestDto {
    private Long tmdbId;
    private String title;
    private String posterPath;
}
