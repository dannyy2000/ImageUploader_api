package com.example.uploader.controller;

import com.example.uploader.data.dtos.request.UserSignInRequest;
import com.example.uploader.data.dtos.request.UserSignUpRequest;
import com.example.uploader.data.dtos.response.UserSignInResponse;
import com.example.uploader.data.dtos.response.UserSignUpResponse;
import com.example.uploader.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final AppUserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpRequest userRequest){
        UserSignUpResponse userResponse = userService.registerUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
    
    @PostMapping("/signIn")
    public ResponseEntity<UserSignInResponse>signIn(
            @RequestBody UserSignInRequest userSignInRequest
            ){
        return ResponseEntity.ok(userService.loginUser(userSignInRequest));
    }



}
