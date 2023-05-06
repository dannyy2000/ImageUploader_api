package com.example.uploader.controller;

import com.example.uploader.data.dtos.request.UploadImageRequest;
import com.example.uploader.data.dtos.response.DeleteImageResponse;
import com.example.uploader.data.dtos.response.SearchImageResponse;
import com.example.uploader.data.dtos.response.UploadImageResponse;
import com.example.uploader.exception.BusinessLogicException;
import com.example.uploader.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/image")
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(@ModelAttribute UploadImageRequest uploadImageRequest){
           UploadImageResponse uploadImageResponse = imageService.uploadImage(uploadImageRequest);
           return new ResponseEntity<>(uploadImageResponse,HttpStatus.CREATED);
       }

    @GetMapping("{imageName}")
    public ResponseEntity<?>search(@PathVariable String imageName){
           SearchImageResponse searchImageResponse = imageService.searchImageByName(imageName);
           return new ResponseEntity<>(searchImageResponse,HttpStatus.FOUND);
        }

    @DeleteMapping("{imageName}")
    public ResponseEntity<?>delete(@PathVariable String imageName){
            DeleteImageResponse deleteImageResponse = imageService.deleteImageByName(imageName);
            return new ResponseEntity<>(deleteImageResponse,HttpStatus.OK);
        }

    }


