package com.example.uploader.data.repository;

import com.example.uploader.data.dtos.response.SearchImageResponse;
import com.example.uploader.data.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Long> {

    Optional<Image> findByImageName(String imageName);
}
