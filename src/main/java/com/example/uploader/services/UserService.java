package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UserRequest;
import com.example.uploader.data.dtos.response.UserResponse;
import com.example.uploader.data.models.User;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    User getUserByUserName(String userName);
}
