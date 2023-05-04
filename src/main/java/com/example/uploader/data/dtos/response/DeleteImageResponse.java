package com.example.uploader.data.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteImageResponse {
    private Long id;
    private String message;
}
