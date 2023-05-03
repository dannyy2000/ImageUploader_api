package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UserRequest;
import com.example.uploader.data.dtos.response.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
}
