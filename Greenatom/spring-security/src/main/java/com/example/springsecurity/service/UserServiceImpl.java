package com.example.springsecurity.service;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.dto.mapper.UserMapper;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(u -> userDtos.add(new UserDto(u.getId(), u.getName(), u.getSurname(), u.getCompany(),
                u.getEmail(), u.getTime())));
        return userDtos;
    }

    @Override
    public UserDto getUser(Long id) {
        User user = getUserFromService(id);
        return userMapper.toDTO(user);
    }


    @Override
    public UserDto saveEmployee(UserDto userDto) {
        return saveAndReturnDTO(userMapper.fromDTO(userDto));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return saveAndReturnDTO(userMapper.fromDTO(userDto));
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private User getUserFromService(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private UserDto saveAndReturnDTO(User user) {
        User savedUser = userRepository.save(user);

        return userMapper.toDTO(savedUser);
    }
}
