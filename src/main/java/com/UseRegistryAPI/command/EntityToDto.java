package com.UseRegistryAPI.command;

import com.UseRegistryAPI.dto.UserResponse;
import com.UseRegistryAPI.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityToDto {
    UserResponse convert(User user);
}
