package com.adityajha.ServiceBookingSystem.services.authentication;

import com.adityajha.ServiceBookingSystem.dto.SignupRequestDTO;
import com.adityajha.ServiceBookingSystem.dto.UserDto;

public interface AuthService {
UserDto signupClient(SignupRequestDTO signupRequestDTO);

Boolean presentByEmail(String email);

UserDto signupCompany(SignupRequestDTO signupRequestDTO);
}
