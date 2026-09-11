package com.MoovieMatcher.moovieMatcher.services;

import com.MoovieMatcher.moovieMatcher.dtos.RegisterRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.UserResponseDto;
import com.MoovieMatcher.moovieMatcher.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto RegisterUser(RegisterRequestDto registerRequestDto) {

    }
}
