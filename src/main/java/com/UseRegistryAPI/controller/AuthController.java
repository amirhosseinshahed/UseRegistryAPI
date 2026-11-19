package com.UseRegistryAPI.controller;

import com.UseRegistryAPI.dto.SignUpRequest;
import com.UseRegistryAPI.dto.UserResponse;
import com.UseRegistryAPI.exception.UsernameAlreadyExistsException;
import com.UseRegistryAPI.model.User;
import com.UseRegistryAPI.service.UserQueryService;
import com.UseRegistryAPI.service.UserSignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/signup")
public class AuthController {
    private final UserSignupService userSignupService;
    private final UserQueryService userQueryService;


    public AuthController(UserSignupService userSignupService, UserQueryService userQueryService) {
        this.userSignupService = userSignupService;
        this.userQueryService = userQueryService;
    }

@PostMapping
    public ResponseEntity<UserResponse> signUp(SignUpRequest request){
        UserResponse byUsername = userQueryService.findByUsername(request.username());

        if (byUsername == null){
            throw  new UsernameAlreadyExistsException();
        }
    UserResponse userResponse = userSignupService.signup(request);
    return ResponseEntity.ok(userResponse);
    }
}
