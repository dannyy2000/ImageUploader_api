package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UserRequest;
import com.example.uploader.data.dtos.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    private UserRequest userRequest;

    @BeforeEach
     void setUp(){
        userRequest = new UserRequest();
        userRequest.setEmail("Danny30@gmail.com");
        userRequest.setUsername("Danny30");
    }

    @Test
    void createUser(){
        UserResponse userResponse = userService.createUser(userRequest);
        assertThat(userResponse).isNotNull();
    }

}