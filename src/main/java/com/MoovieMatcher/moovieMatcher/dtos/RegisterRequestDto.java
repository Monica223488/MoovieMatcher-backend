package com.MoovieMatcher.moovieMatcher.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
        private String email;
        private String password;
        private String name;
}
