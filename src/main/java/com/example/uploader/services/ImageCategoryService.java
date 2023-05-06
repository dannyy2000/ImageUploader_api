package com.example.uploader.services;

import com.example.uploader.data.dtos.request.ImageCategoryRequest;
import com.example.uploader.data.dtos.response.ImageCategoryResponse;

public interface ImageCategoryService {

    ImageCategoryResponse createCategory(ImageCategoryRequest imageCategoryRequest);
}
