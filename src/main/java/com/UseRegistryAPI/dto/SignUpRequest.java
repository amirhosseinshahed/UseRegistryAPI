package com.UseRegistryAPI.dto;

import jakarta.validation.constraints.*;

public record SignUpRequest(
        @NotBlank @Size(min = 5, max = 20) @Pattern(regexp = "[a-zA-Z0-9_]+")
        String username,
        @NotBlank @Pattern(regexp = "[\\x20-\\x7E]+", message = "Password must contain printable ASCII characters")
        String password,
        @NotBlank @Size(min = 5, max = 100)
        String fullName,
        @Min(5)
        @Max(110)
        short age
) {
}
