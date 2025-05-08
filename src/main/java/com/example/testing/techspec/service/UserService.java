package com.example.testing.techspec.service;

import com.example.testing.techspec.dto.UserDto;
import com.example.testing.techspec.entities.User;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    User getUserEntityById(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}
