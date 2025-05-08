package com.example.testing.techspec.mapper;

import com.example.testing.techspec.dto.UserDto;
import com.example.testing.techspec.entities.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = SubscribeMapper.class)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserDto dto, @MappingTarget User user);
}