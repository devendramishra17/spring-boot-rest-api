package com.javaguides.springboot_restful_webservices.service.impl;

import com.javaguides.springboot_restful_webservices.dto.UserDto;
import com.javaguides.springboot_restful_webservices.entity.User;
import com.javaguides.springboot_restful_webservices.exception.EmailAlreadyExistsException;
import com.javaguides.springboot_restful_webservices.exception.ResourceNotFoundException;
import com.javaguides.springboot_restful_webservices.mapper.AutoUserMapper;
import com.javaguides.springboot_restful_webservices.mapper.UserMapper;
import com.javaguides.springboot_restful_webservices.repository.UserRepository;
import com.javaguides.springboot_restful_webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // userdto ko user jpa entity me convert krna hai
//        User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto,User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists in the database");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);


        //convert user jpa entity to UserDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

//        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;

    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User" , "id" , userId)
        );
//        return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user , UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }


    @Override
    public List<UserDto> getAllUsers() {

        List<User> users =  userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto)  //iss line ka matlab nhi samajh aya
//                .collect(Collectors.toList());

//        return users.stream().map((user) -> modelMapper.map(user,UserDto.class))
//                .collect(Collectors.toList());
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User" , "id" , user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updatedUser);
//        return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }


    @Override
    public void deleteUser(Long userId) {

        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User" , "id" , userId)
        );
        userRepository.deleteById(userId);
    }
}
