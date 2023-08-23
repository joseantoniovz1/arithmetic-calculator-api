package com.challenge.api.controller;

import com.challenge.api.dto.UserDto;
import com.challenge.api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "User Controller",
        description = "Arithmetic Calculator REST API"
)
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("email") String email, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(email, userDto));
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("email") String email) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
