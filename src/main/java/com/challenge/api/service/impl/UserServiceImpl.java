package com.challenge.api.service.impl;

import com.challenge.api.dto.UserDto;
import com.challenge.api.entity.User;
import com.challenge.api.repository.UserReporsitory;
import com.challenge.api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserReporsitory reporsitory;

    private ModelMapper mapper;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = reporsitory.findAll();
        return users.stream().map((user) -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return mapper.map(reporsitory.findUserByEmail(email), UserDto.class);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = reporsitory.findUserByEmail(email);
        if (user != null) {
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setStatus(userDto.getStatus());
            return mapper.map(reporsitory.save(user), UserDto.class);
        }
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }
}
