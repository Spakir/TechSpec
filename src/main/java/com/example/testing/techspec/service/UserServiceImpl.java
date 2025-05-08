package com.example.testing.techspec.service;

import com.example.testing.techspec.dto.UserDto;
import com.example.testing.techspec.entities.User;
import com.example.testing.techspec.mapper.UserMapper;
import com.example.testing.techspec.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        User userEntity = userMapper.toEntity(userDto);
        User savedUserEntity = userRepository.save(userEntity);

        return userMapper.toDto(savedUserEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        User userEntity = findUserByIdOrThrow(id);

        return userMapper.toDto(userEntity);
    }

    @Override
    public User getUserEntityById(Long id) {
        return findUserByIdOrThrow(id);
    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        User existUserEntity = findUserByIdOrThrow(id);
        userMapper.updateUserFromDto(userDto, existUserEntity);

        return userMapper.toDto(existUserEntity);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = findUserByIdOrThrow(id);
        userRepository.delete(user);
    }

    private User findUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Юзера с таким ID не существует"));
    }
}
