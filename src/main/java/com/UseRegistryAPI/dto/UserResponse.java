package com.UseRegistryAPI.dto;

public record UserResponse(
        Long id,
        String username,
        String fullName,
        short age
) {
}
