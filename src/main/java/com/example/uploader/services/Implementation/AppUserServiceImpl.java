package com.example.uploader.services.Implementation;

import com.example.uploader.data.dtos.request.UserSignInRequest;
import com.example.uploader.data.dtos.request.UserSignUpRequest;
import com.example.uploader.data.dtos.response.UserSignInResponse;
import com.example.uploader.data.dtos.response.UserSignUpResponse;
import com.example.uploader.data.models.User;
import com.example.uploader.data.repository.UserRepository;
import com.example.uploader.exception.BusinessLogicException;
import com.example.uploader.security.services.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.uploader.services.AppUserService;

@Service
@AllArgsConstructor
@Slf4j

public class AppUserServiceImpl implements AppUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserSignUpResponse registerUser(UserSignUpRequest userRequest) {
        log.info("Request to create a user with payload={}",userRequest);
        User appUser = User.builder()
                        .firstName(userRequest.getFirstName())
                        .lastName(userRequest.getLastName())
                        .email(userRequest.getEmail())
                        .password(passwordEncoder.encode(userRequest.getPassword()))
                        .build();
       User savedUser = userRepository.save(appUser);
       UserSignUpResponse userResponse = getUserResponse(savedUser);
       return userResponse;
    }

    @Override
    public UserSignInResponse loginUser(UserSignInRequest userSignInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userSignInRequest.getEmail(),userSignInRequest.getPassword()));
                User user = userRepository.findByEmail(userSignInRequest.getEmail());
                if(user == null)throw new BusinessLogicException("Invalid email or password");
                var jwt = jwtService.generateToken(user);
                return UserSignInResponse.builder().accessToken(jwt).build();
    }


    private UserSignUpResponse getUserResponse(User savedUser ) {

        UserSignUpResponse userResponse = new UserSignUpResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setSuccessful(true);
        userResponse.setMessage("User created successfully");
        return userResponse;
    }
}
