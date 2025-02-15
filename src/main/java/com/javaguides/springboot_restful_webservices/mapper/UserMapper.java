package com.javaguides.springboot_restful_webservices.mapper;

import com.javaguides.springboot_restful_webservices.dto.UserDto;
import com.javaguides.springboot_restful_webservices.entity.User;

public class UserMapper {

    //common logic to convert user jpa entity to user dto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
    // convert userDto to user jpa entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
