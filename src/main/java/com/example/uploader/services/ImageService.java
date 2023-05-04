package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UploadImageRequest;
import com.example.uploader.data.dtos.response.DeleteImageResponse;
import com.example.uploader.data.dtos.response.SearchImageResponse;
import com.example.uploader.data.dtos.response.UploadImageResponse;
import com.example.uploader.data.models.Image;

public interface ImageService {

  UploadImageResponse uploadImage(UploadImageRequest imageRequest);

  SearchImageResponse searchImageByName(String imageName);

  DeleteImageResponse deleteImageByName(String imageName);

}
