package com.pigeonpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pigeonpi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	
}
