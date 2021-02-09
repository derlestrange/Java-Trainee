package com.example.springsecurity.service;

import com.example.springsecurity.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User saveEmployee(User user);

    public User updateUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);
}
