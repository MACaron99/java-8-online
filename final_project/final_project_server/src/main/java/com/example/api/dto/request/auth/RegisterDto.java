package com.example.api.dto.request.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

    String email;
    String password;
}
