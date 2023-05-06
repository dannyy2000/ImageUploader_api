package com.example.uploader.controller;

import com.example.uploader.data.dtos.request.ImageCategoryRequest;
import com.example.uploader.data.dtos.response.ImageCategoryResponse;
import com.example.uploader.services.ImageCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final ImageCategoryService imageCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody ImageCategoryRequest imageCategoryRequest){
        ImageCategoryResponse imageCategoryResponse = imageCategoryService.createCategory(imageCategoryRequest);
        return new ResponseEntity<>(imageCategoryResponse, HttpStatus.CREATED);
    }

}
