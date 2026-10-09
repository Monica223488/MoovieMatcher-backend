package com.MoovieMatcher.moovieMatcher.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private UUID id;
    private String email;
    private String name;
}
