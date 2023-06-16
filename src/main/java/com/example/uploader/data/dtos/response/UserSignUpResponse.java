package com.example.uploader.data.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpResponse {

    private Long id;
    private String message;
    private boolean isSuccessful;

}
