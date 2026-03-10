package com.assessment2.assessment2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment2.assessment2.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUsername(String username);
}