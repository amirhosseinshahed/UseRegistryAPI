package com.UseRegistryAPI.service;

import com.UseRegistryAPI.command.DtoToEntity;
import com.UseRegistryAPI.command.EntityToDto;
import com.UseRegistryAPI.dto.UserResponse;
import com.UseRegistryAPI.model.User;
import com.UseRegistryAPI.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class UserQueryService {

    private final UserInfoRepository userInfoRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;



    public UserQueryService(UserInfoRepository userInfoRepository, DtoToEntity dtoToEntity, EntityToDto entityToDto) {
        this.userInfoRepository = userInfoRepository;
        this.dtoToEntity = dtoToEntity;
        this.entityToDto = entityToDto;
    }



    public UserResponse findByUsername(String username){
        Optional<User> byUsername = userInfoRepository.findByUsername(username);
        if (byUsername.isEmpty())
            return null;

        return entityToDto.convert(byUsername.get());
    }

    public List<UserResponse> findAll(){
        return userInfoRepository.findAll()
                .stream().map(user -> entityToDto.convert(user))
                .toList();
    }
}
