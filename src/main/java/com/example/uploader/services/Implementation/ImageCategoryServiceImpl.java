package com.example.uploader.services.Implementation;

import com.example.uploader.data.dtos.request.ImageCategoryRequest;
import com.example.uploader.data.dtos.response.ImageCategoryResponse;
import com.example.uploader.data.models.Image;
import com.example.uploader.data.models.ImageCategory;
import com.example.uploader.data.repository.ImageCategoryRepository;
import com.example.uploader.data.repository.ImageRepository;
import com.example.uploader.exception.BusinessLogicException;
import com.example.uploader.services.ImageCategoryService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ImageCategoryServiceImpl implements ImageCategoryService {
    private final ImageRepository imageRepository;
    private final ImageCategoryRepository imageCategoryRepository;

//    @Override
//    public ImageCategoryResponse createCategory(ImageCategoryRequest imageCategoryRequest) {
//        log.info("Request to create a category with payload={}",imageCategoryRequest);
//        Set<String> imageName = new HashSet<>(imageCategoryRequest.getImageName());
//        Optional<Image> findImage = imageRepository.findByImageName(imageName.toString());
//        if (findImage.isEmpty()) throw new BusinessLogicException("Image name does not exist");
//
//        Image image = findImage.get();
//        String imageUrl = image.getImage();
//        Set<Image> imageUrls = new HashSet<>();
//        image.setImage(imageUrl);
//        imageUrls.add(image);
//
//        ImageCategory imageCategory = new ImageCategory();
//        imageCategory.setCategoryName(imageCategoryRequest.getCategoryName());
//        imageCategory.setImages(imageUrls);
//        imageCategoryRepository.save(imageCategory);
//
//        ImageCategoryResponse imageCategoryResponse = getImageCategory(imageCategory);
//        return imageCategoryResponse;
//
//    }
@Override
public ImageCategoryResponse createCategory(ImageCategoryRequest imageCategoryRequest) {
    log.info("Request to create a category with payload={}", imageCategoryRequest);
        String imageNames = imageCategoryRequest.getImageName();

    Optional<Image> findImage = imageRepository.findByImageName(imageNames);
    if (findImage.isEmpty()) {
        throw new BusinessLogicException("Image name does not exist");
    }

    Image image = findImage.get();
    String imageUrl = image.getImage();
    Set<Image> imageUrls = new HashSet<>();
    image.setImage(imageUrl);
    imageUrls.add(image);

    ImageCategory imageCategory = new ImageCategory();
    imageCategory.setCategoryName(imageCategoryRequest.getCategoryName());
    imageCategory.setImages(imageUrls);
    imageCategoryRepository.save(imageCategory);

    ImageCategoryResponse imageCategoryResponse = getImageCategory(imageCategory);
    return imageCategoryResponse;
}


    private ImageCategoryResponse getImageCategory(ImageCategory imageCategory) {
        ImageCategoryResponse imageCategoryResponse = new ImageCategoryResponse();
        imageCategoryResponse.setId(imageCategory.getId());
        imageCategoryResponse.setMessage("Image category created successfully");
        return imageCategoryResponse;
    }
}
