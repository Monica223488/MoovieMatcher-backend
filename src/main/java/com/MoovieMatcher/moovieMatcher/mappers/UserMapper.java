package com.MoovieMatcher.moovieMatcher.mappers;

import com.MoovieMatcher.moovieMatcher.dtos.LoginRequestDto;
import com.MoovieMatcher.moovieMatcher.dtos.RegisterRequestDto;
import com.MoovieMatcher.moovieMatcher.models.User;

public class UserMapper {

    public static User toEntity(RegisterRequestDto RegisterRequestDto){
        User user = new User(
            registerRequestDto.getEmail(),
            registerRequestDto.getName(),
            registerRequestDto.getPassword()
        );
        return user;
    }
}
