package com.example.testing.techspec.mapper;

import com.example.testing.techspec.dto.UserDto;
import com.example.testing.techspec.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SubscribeMapper.class)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);
}