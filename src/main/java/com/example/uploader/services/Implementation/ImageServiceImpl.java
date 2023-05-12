package com.example.uploader.services.Implementation;

import com.example.uploader.cloud.CloudService;
import com.example.uploader.data.dtos.request.UploadImageRequest;
import com.example.uploader.data.dtos.response.DeleteImageResponse;
import com.example.uploader.data.dtos.response.SearchImageResponse;
import com.example.uploader.data.dtos.response.UploadImageResponse;
import com.example.uploader.data.models.Image;
import com.example.uploader.data.repository.ImageRepository;
import com.example.uploader.exception.BusinessLogicException;
import com.example.uploader.services.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final CloudService cloudService;

    private final ImageRepository imageRepository;

    @Override
    public UploadImageResponse uploadImage(UploadImageRequest imageRequest) {
        log.info("Request to upload an image with payload={}",imageRequest);

        var imageUrl = cloudService.upload(imageRequest.getImage(), imageRequest.getImageName());
        Image image = new Image();
        image.setImage(imageUrl);
        image.setImageName(imageRequest.getImageName());
        if (imageRepository.existsImageByImageName(imageRequest.getImageName())) {
            throw new BusinessLogicException("Image name with this name already exists");
        }
        Image savedImage = imageRepository.save(image);

        UploadImageResponse imageResponse = new UploadImageResponse();
        imageResponse.setId(savedImage.getId());
        imageResponse.setSuccessful(true);
        imageResponse.setMessage("Image uploaded successfully");
        return imageResponse;

    }

    public SearchImageResponse searchImageByName(String imageName) {
        log.info("Request to search for an image with payload={}",imageName);
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

    @Override
    public DeleteImageResponse deleteImageByName(String imageNamee) {
        log.info("Request to delete an image with payload={}",imageNamee);
        Optional<Image> findImage = imageRepository.findByImageName(imageNamee);
        if (findImage.isPresent()) {
            Image image = findImage.get();
            var imageName = image.getImage();
            imageRepository.deleteByImageName(imageName);
            DeleteImageResponse deleteImageResponse = new DeleteImageResponse();
            deleteImageResponse.setMessage("Deleted successfully");
            return deleteImageResponse;
        }
        throw new BusinessLogicException("Image with name " + imageNamee + " does not exist");
    }

}
