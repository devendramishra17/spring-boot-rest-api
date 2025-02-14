package com.javaguides.springboot_restful_webservices.repository;

import com.javaguides.springboot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


//ye crud methods ye extends krta hai jpa repository se
public interface    UserRepository extends JpaRepository<User , Long>   {

}
