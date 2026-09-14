package com.MoovieMatcher.moovieMatcher.services;

import com.MoovieMatcher.moovieMatcher.dtos.LoginRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.RegisterRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.UserResponseDto;
import com.MoovieMatcher.moovieMatcher.mappers.UserMapper;
import com.MoovieMatcher.moovieMatcher.models.User;
import com.MoovieMatcher.moovieMatcher.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto registerUser(RegisterRequestDto registerRequestDto) {
        User user = UserMapper.toEntity(registerRequestDto);
        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodedPassword);
        User userResult = userRepository.save(user);
        return UserMapper.toResponseDto(userResult);
    }

    public UserResponseDto loginUser(LoginRequestDto loginRequestDto){
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));
        boolean passwordMatches = passwordEncoder.matches(
                loginRequestDto.getPassword(),
        user.getPassword()
        );
        if (!passwordMatches) {
            throw new RuntimeException("Invalid password");
        }

        return null;
    }
}
