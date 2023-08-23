package com.challenge.api.service;

import com.challenge.api.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserByEmail(String email);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);

}
