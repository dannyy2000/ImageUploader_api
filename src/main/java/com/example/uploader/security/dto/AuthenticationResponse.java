package com.example.uploader.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter

public class AuthenticationResponse {

    private final String jwt;
}
