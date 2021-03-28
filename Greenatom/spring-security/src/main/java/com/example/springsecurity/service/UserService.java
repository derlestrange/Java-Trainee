package com.example.springsecurity.service;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.model.User;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUsers();

    public UserDto saveEmployee(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public UserDto getUser(Long id);

    public void deleteUser(Long id);

}
