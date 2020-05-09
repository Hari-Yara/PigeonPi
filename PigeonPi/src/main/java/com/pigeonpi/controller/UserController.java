package com.pigeonpi.controller;

import java.net.URI;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pigeonpi.entity.User;
import com.pigeonpi.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		System.out.println(user);
		Optional<User> optional = userRepository.findById(user.getUserId());
		if (optional.isPresent()) {
			User user2 = userRepository.getOne(user.getUserId());
			int oldLatch = user2.getLatch();
			user2.setLatch(oldLatch + 1);
			// return userRepository.save(user2);
			userRepository.save(user2);

		} else {
			user.setLatch(1);
			// return userRepository.save(user);
			userRepository.save(user);
		}
		//to return HTTP status code and location of created user like (www.abc.com/users/1245)
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/users/activeUsers")
	public List<User> getActiveUsers(@RequestBody List<User> users) {
		List<String> rawIds = new ArrayList<>();
		List<User> activeUsers = new ArrayList<>();
		for (User user : users) {
			rawIds.add(user.getUserId());
		}
		activeUsers = userRepository.findAllById(rawIds);
		return activeUsers;
	}
}
