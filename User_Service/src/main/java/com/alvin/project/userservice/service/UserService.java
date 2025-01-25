package com.alvin.project.userservice.service;

import com.alvin.project.userservice.dto.UserDTO;

public interface UserService {
    void registerUser(UserDTO userDTO);
}