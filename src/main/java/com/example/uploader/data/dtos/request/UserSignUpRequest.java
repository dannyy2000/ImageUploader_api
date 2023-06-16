package com.example.uploader.data.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserSignUpRequest {
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String firstName;
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String lastName;
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String email;
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String password;
}
