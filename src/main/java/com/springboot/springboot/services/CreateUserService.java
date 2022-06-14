package com.springboot.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;

@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  public User execute(User user) {

    List<User> existsUser = userRepository.findByUsername(user.getUsername());

    if (existsUser != null) {
      throw new Error("User already exists!");
    }

    User createdUser = userRepository.save(user);

    return createdUser;
  }
}
