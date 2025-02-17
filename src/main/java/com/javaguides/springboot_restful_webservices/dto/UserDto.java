package com.javaguides.springboot_restful_webservices.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


        private Long id;
        @NotEmpty(message = "user firstName should not be null or empty")
        private String firstName;
        @NotEmpty(message = "user lastname should not be empty or null")
        private String lastName;
        @NotEmpty(message = "user email should not be null or empty")
        @Email(message = "must be a valid email")
        private String email;

}
