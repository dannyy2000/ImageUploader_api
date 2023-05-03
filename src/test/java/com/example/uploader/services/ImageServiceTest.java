package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UploadImageRequest;
import com.example.uploader.data.dtos.response.SearchImageResponse;
import com.example.uploader.data.dtos.response.UploadImageResponse;
import com.example.uploader.data.models.Image;
import com.example.uploader.data.repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ImageServiceTest {

    @Autowired

    private ImageService imageService;

    private UploadImageRequest imageRequest;

//    private ImageRepository imageRepository;

@BeforeEach
    void setup()  {
    imageRequest = new UploadImageRequest();

    }

    @Test
    void uploadImageTest() throws IOException {
        MockMultipartFile file =
                new MockMultipartFile("Fineboy",
                new FileInputStream("C:\\Users\\user\\Documents\\fineboy.jpg"));
         imageRequest.setImage(file);
        imageRequest.setImageName("Fineboy");
        UploadImageResponse uploadImageResponse = imageService.uploadImage(imageRequest);
        assertThat(uploadImageResponse).isNotNull();

//    String imageName = "fineboy";
//    var cloudinaryUrl = cloudService.upload(file,imageName);
//    assertThat(cloudinaryUrl).isNotNull();

}

//@Test
//    void searchImageByImageNameTest() throws IOException {
//    MockMultipartFile file =
//            new MockMultipartFile("fineboy",
//                    new FileInputStream("C:\\Users\\user\\Documents\\fineboy.jpg"));
//    imageRequest.setImage(file);
//    imageRequest.setImageName("Fineboy");
//    UploadImageResponse uploadImageResponse = imageService.uploadImage(imageRequest);
//
//
//    String imageName = "Fineboy";
//
//    Image image = imageService.searchImageByName(imageName);
////    assertThat(searchImageResponse.getImage()).isNotNull();
//    assertEquals(imageName,image.getImageName());
////    System.out.println(searchImageResponse.toString());

    @Test
    public void testSearchImageByName() {
        String imageName = "Fineboy";
        Image image = new Image();
        image.setImage("C:\\Users\\user\\Documents\\fineboy.jpg");
        image.setImageName(imageName);
        SearchImageResponse imageResponse = imageService.searchImageByName(imageName);
        assertNotNull(imageResponse);
        assertEquals(imageName, imageResponse.getImageName());
//        assertEquals(image.getImage(), result.getImage());
    }



}

