package com.microservice.UserService.service;

import com.microservice.UserService.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User addUser(User user);
    public User getUser(int userId);
    public List<User> getAllUser();
    public User deleteUser(int userId);
}
