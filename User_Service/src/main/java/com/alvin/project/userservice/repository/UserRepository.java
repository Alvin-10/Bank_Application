package com.alvin.project.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvin.project.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}