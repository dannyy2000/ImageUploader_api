package com.example.uploader.data.dtos.request;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageCategoryRequest {

    private String categoryName;
    private String imageName;

}
