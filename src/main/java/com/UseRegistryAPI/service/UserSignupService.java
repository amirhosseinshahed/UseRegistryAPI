package com.UseRegistryAPI.service;

import com.UseRegistryAPI.dto.SignUpRequest;
import com.UseRegistryAPI.dto.UserResponse;
import com.UseRegistryAPI.model.User;
import com.UseRegistryAPI.repository.UserInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSignupService {
    private final UserInfoRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserSignupService(UserInfoRepository repository , PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public UserResponse signup(SignUpRequest request){
        String passwordHash = passwordEncoder.encode(request.password());
        User user = User.builder()
                .username(request.username()).password(passwordHash)
                .fullName(request.fullName()).age(request.age()).build();
       User returnedUser = repository.create(user);

       return new  UserResponse(returnedUser.getId()
               , returnedUser.getUsername()
               , returnedUser.getFullName()
               ,returnedUser.getAge());
    }

}
