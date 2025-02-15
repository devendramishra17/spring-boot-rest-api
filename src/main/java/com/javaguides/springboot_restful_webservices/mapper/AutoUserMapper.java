package com.javaguides.springboot_restful_webservices.mapper;

import com.javaguides.springboot_restful_webservices.dto.UserDto;
import com.javaguides.springboot_restful_webservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

//    @Mapping(source = "email" , target = "emailAddress")  //agar user dto me emailaddress hai aur user me email hai to uske liye ye annotation add kiya hai

    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);


}
