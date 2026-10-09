package com.MoovieMatcher.moovieMatcher.mappers;

import com.MoovieMatcher.moovieMatcher.dtos.RegisterRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.UserResponseDto;
import com.MoovieMatcher.moovieMatcher.models.User;

public class UserMapper {

    public static User toEntity(RegisterRequestDto registerRequestDto){
        User user = new User(
            registerRequestDto.getEmail(),
            registerRequestDto.getPassword(),
            registerRequestDto.getName()
        );
        return user;
    }

    public static UserResponseDto toResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        return userResponseDto;
}
}
