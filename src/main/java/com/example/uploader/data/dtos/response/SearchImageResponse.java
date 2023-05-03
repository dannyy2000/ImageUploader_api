package com.example.uploader.data.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchImageResponse {
    private Long id;
    private String image;
    private String imageName;
}
