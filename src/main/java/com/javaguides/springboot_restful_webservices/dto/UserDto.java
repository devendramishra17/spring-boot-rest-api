package com.javaguides.springboot_restful_webservices.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Userdto Model Information"
)

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {



        private Long id;
        @Schema(
                description = "User First Name"
        )
        @NotEmpty(message = "user firstName should not be null or empty")

        private String firstName;

        @Schema(
                description = "User last name"
        )
        @NotEmpty(message = "user lastname should not be empty or null")
        private String lastName;

        @Schema(
                description = "user email address"
        )
        @NotEmpty(message = "user email should not be null or empty")
        @Email(message = "must be a valid email")
        private String email;

}
