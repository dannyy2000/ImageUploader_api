package com.example.uploader.data.repository;

import com.example.uploader.data.models.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Long> {

    Optional<Image> findByImageName(String imageName);

//    boolean existByImageName(String name);
    boolean existsImageByImageName(String imageName);

    @Transactional
    @Modifying
    void deleteByImageName(String imageName);

}
