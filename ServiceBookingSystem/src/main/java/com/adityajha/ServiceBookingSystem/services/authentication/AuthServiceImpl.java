package com.adityajha.ServiceBookingSystem.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;

import com.adityajha.ServiceBookingSystem.dto.SignupRequestDTO;
import com.adityajha.ServiceBookingSystem.dto.UserDto;
import com.adityajha.ServiceBookingSystem.entity.User;
import com.adityajha.ServiceBookingSystem.enums.UserRole;
import com.adityajha.ServiceBookingSystem.repository.UserRepository;

public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){
        User user =new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }
    public Boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email)!=null;
    }

    public UserDto signupCompany(SignupRequestDTO signupRequestDTO){
        User user =new User();

        user.setName(signupRequestDTO.getName());
        
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }

}
