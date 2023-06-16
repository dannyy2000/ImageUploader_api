package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UserSignUpRequest;
import com.example.uploader.data.dtos.response.UserSignUpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private AppUserService userService;

    private UserSignUpRequest userRequest;

    @BeforeEach
     void setUp(){
        userRequest = new UserSignUpRequest();
        userRequest.setEmail("Danny30@gmail.com");
    }

    @Test
    void createUser(){
        UserSignUpResponse userResponse = userService.registerUser(userRequest);
        assertThat(userResponse).isNotNull();
    }

}