package com.javaguides.springboot_restful_webservices.service;


import com.javaguides.springboot_restful_webservices.dto.UserDto;
import com.javaguides.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}

