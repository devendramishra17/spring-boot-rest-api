package com.javaguides.springboot_restful_webservices.repository;

import com.javaguides.springboot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;


//ye crud methods ye extends krta hai jpa repository se
public interface    UserRepository extends JpaRepository<User , Long>   {

    //custom query method
    Optional<User> findByEmail(String email);
}
