package com.example.uploader.cloud;


import org.springframework.web.multipart.MultipartFile;

public interface CloudService {

    String upload(MultipartFile image,String name);
}
