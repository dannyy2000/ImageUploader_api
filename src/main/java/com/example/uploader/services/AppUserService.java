package com.example.uploader.services;

import com.example.uploader.data.dtos.request.UserSignInRequest;
import com.example.uploader.data.dtos.request.UserSignUpRequest;
import com.example.uploader.data.dtos.response.UserSignInResponse;
import com.example.uploader.data.dtos.response.UserSignUpResponse;

public interface AppUserService {

    UserSignUpResponse registerUser(UserSignUpRequest userRequest);
    UserSignInResponse loginUser(UserSignInRequest userSignInRequest);


}
