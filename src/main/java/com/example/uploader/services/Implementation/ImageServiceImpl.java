package com.example.uploader.services.Implementation;

import com.example.uploader.cloud.CloudService;
import com.example.uploader.data.dtos.request.UploadImageRequest;
import com.example.uploader.data.dtos.response.SearchImageResponse;
import com.example.uploader.data.dtos.response.UploadImageResponse;
import com.example.uploader.data.models.Image;
import com.example.uploader.data.repository.ImageRepository;
import com.example.uploader.exception.BusinessLogicException;
import com.example.uploader.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final CloudService cloudService;

    private final ImageRepository imageRepository;

    @Override
    public UploadImageResponse uploadImage(UploadImageRequest imageRequest) {
        var imageUrl = cloudService.upload(imageRequest.getImage(),imageRequest.getImageName());
        Image image = new Image();
        image.setImage(imageUrl);
        image.setImageName(imageRequest.getImageName());

        Image savedImage = imageRepository.save(image);

        UploadImageResponse imageResponse = new UploadImageResponse();
        imageResponse.setId(savedImage.getId());
        imageResponse.setSuccessful(true);
        imageResponse.setMessage("Image uploaded successfully");
        return imageResponse;

    }

    public SearchImageResponse searchImageByName(String imageName) {
        Optional<Image> findImage = imageRepository.findByImageName(imageName);
        if (findImage.isPresent()) {
            Image image = findImage.get();
            String imageUrl = image.getImage();
            SearchImageResponse imageResponse = new SearchImageResponse();
            imageResponse.setId(image.getId());
            imageResponse.setImage(imageUrl);
            imageResponse.setImageName(image.getImageName());
            return imageResponse;
        }
        throw new BusinessLogicException("Image with name " + imageName + " does not exist");
    }



}
