package com.adityajha.ServiceBookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.adityajha.ServiceBookingSystem.dto.SignupRequestDTO;
import com.adityajha.ServiceBookingSystem.dto.UserDto;
import com.adityajha.ServiceBookingSystem.services.authentication.AuthService;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO){
        if(authService.presentByEmail(signupRequestDTO.getEmail()))
        {
            return new ResponseEntity<>("Client already exists with this email",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto CreatedUser=authService.signupClient(signupRequestDTO);

        return new ResponseEntity<>(CreatedUser,HttpStatus.OK);
    }

    
    @PostMapping("/company/sign-up")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO){
        if(authService.presentByEmail(signupRequestDTO.getEmail()))
        {
            return new ResponseEntity<>("Company already exists with this email",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto CreatedUser=authService.signupClient(signupRequestDTO);

        return new ResponseEntity<>(CreatedUser,HttpStatus.OK);
    }

}
