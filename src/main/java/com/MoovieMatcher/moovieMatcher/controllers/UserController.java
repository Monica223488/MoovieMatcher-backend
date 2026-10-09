package com.MoovieMatcher.moovieMatcher.controllers;

import com.MoovieMatcher.moovieMatcher.dtos.LoginRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.LoginResponseDto;
import com.MoovieMatcher.moovieMatcher.dtos.RegisterRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.UserResponseDto;
import com.MoovieMatcher.moovieMatcher.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(
            @RequestBody RegisterRequestDto registerRequestDto){
        UserResponseDto user = userService.registerUser(registerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(
            @RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponse = userService.loginUser(loginRequestDto);
        return ResponseEntity.ok(loginResponse);
    }
}
