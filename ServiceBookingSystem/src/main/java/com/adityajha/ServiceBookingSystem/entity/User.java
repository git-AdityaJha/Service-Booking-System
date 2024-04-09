package com.adityajha.ServiceBookingSystem.entity;

import com.adityajha.ServiceBookingSystem.dto.UserDto;
import com.adityajha.ServiceBookingSystem.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

   private UserRole role;

   public UserDto getDto(){
    UserDto userDto=new UserDto();
    userDto.setId(id);
    userDto.setName(name);
    userDto.setLastname(lastname);
    userDto.setRole(role);

    return userDto;
   }
   
}
