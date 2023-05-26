package com.example.uploader.controller;

import com.example.uploader.data.dtos.request.ImageCategoryRequest;
import com.example.uploader.data.dtos.response.ImageCategoryResponse;
import com.example.uploader.security.dto.AuthenticationRequest;
import com.example.uploader.security.dto.AuthenticationResponse;
import com.example.uploader.security.services.MyUserDetailsService;
import com.example.uploader.services.ImageCategoryService;
import com.example.uploader.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.junit.runner.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final ImageCategoryService imageCategoryService;
    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService myUserDetailsService;

    private final JwtUtil jwtUtil;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ImageCategoryRequest imageCategoryRequest) {
        ImageCategoryResponse imageCategoryResponse = imageCategoryService.createCategory(imageCategoryRequest);
        return new ResponseEntity<>(imageCategoryResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassWord())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}


