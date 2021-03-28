package com.example.springsecurity.controller;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class MyController {

    private final UserService userService;

    @GetMapping("/members")
    public List<UserDto> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/members/{id}")
    public UserDto userDto(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("members/save")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveEmployee(userDto);
    }

    @PutMapping("members/update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.saveEmployee(userDto);
    }

    @DeleteMapping("members/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
