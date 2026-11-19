package com.UseRegistryAPI.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("Username Already Exists");
    }
}
