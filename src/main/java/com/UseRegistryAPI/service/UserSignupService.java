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
    public UserSignupService(UserInfoRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponse signup(SignUpRequest request) {
        String passwordHash = passwordEncoder.encode(request.password());
        User user = dtoToEntity(request, passwordHash);
        User returnedUser = repository.create(user);

        return entityToDto(returnedUser);
    }


    private UserResponse entityToDto(User user) {
        return new UserResponse(
                user.getId()
                , user.getUsername()
                , user.getFullName()
                , user.getAge()
        );
    }

    private User dtoToEntity(SignUpRequest request, String passwordHash) {
        return User.builder()
                .username(request.username()).password(passwordHash)
                .fullName(request.fullName()).age(request.age()).build();
    }
}
