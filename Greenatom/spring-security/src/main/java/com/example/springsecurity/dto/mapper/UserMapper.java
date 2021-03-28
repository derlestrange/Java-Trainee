package com.example.springsecurity.dto.mapper;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    UserDto toDTO(User user);

//    @Mapping(target = "salary", source = "")
//    @Mapping(target = "password", source = "")
    User fromDTO(UserDto userDto);

    List<UserDto> listToDTO(List<User> users);

}
