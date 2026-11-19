package com.UseRegistryAPI.command;

import com.UseRegistryAPI.dto.SignUpRequest;
import com.UseRegistryAPI.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoToEntity {
    User convert(SignUpRequest request);
}
