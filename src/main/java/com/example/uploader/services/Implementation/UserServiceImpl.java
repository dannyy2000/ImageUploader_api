package com.example.uploader.services.Implementation;

import ch.qos.logback.core.util.FileSize;
import com.example.uploader.data.dtos.request.UserRequest;
import com.example.uploader.data.dtos.response.UserResponse;
import com.example.uploader.data.models.User;
import com.example.uploader.data.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.uploader.services.UserService;

@Service
@AllArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {

    private  final ModelMapper mapper;

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        log.info("Request to create a user with payload={}",userRequest);
        User appUser = mapper.map(userRequest,User.class);
       User savedUser = userRepository.save(appUser);
       UserResponse userResponse = getUserResponse(savedUser);
       return userResponse;
    }

    private UserResponse getUserResponse(User savedUser ) {

        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setSuccessful(true);
        userResponse.setMessage("User created successfully");
        return userResponse;
    }
}
