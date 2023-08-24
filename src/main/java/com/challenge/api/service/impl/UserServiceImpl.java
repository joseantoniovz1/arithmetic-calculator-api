package com.challenge.api.service.impl;

import com.challenge.api.dto.RecordReferenceDto;
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

    private UserReporsitory repository;

    private ModelMapper mapper;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(user -> {
            UserDto userDto = mapper.map(user, UserDto.class);
            if(user.getRecords() != null) {
                user.getRecords().stream().map((record -> mapper.map(record, RecordReferenceDto.class)))
                        .collect(Collectors.toList());
            }
            return userDto;
        }).collect(Collectors.toList());

    }

    @Override
    public UserDto getUserByEmail(String email) {
        return mapper.map(repository.findUserByEmail(email), UserDto.class);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = repository.findUserByEmail(email);
        if (user != null) {
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setStatus(userDto.getStatus());
            return mapper.map(repository.save(user), UserDto.class);
        }
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }
}
