package com.example.uploader.data.repository;


import com.example.uploader.data.models.ImageCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageCategoryRepository extends JpaRepository<ImageCategory,Long> {
}
