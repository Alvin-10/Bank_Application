package com.alvin.project.userservice.service;

import com.alvin.project.userservice.dto.LoginDTO;

public interface AuthService {
    String authenticate(LoginDTO loginDTO);
}