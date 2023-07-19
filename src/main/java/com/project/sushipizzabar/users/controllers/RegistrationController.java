package com.project.sushipizzabar.users.controllers;

import com.project.sushipizzabar.users.UserService;
import com.project.sushipizzabar.users.dto.UserCreateRequest;
import com.project.sushipizzabar.users.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserCreateRequest userCreateRequest) {
        if (!Arrays.equals(userCreateRequest.getPassword(), userCreateRequest.getPasswordRetry())) {
            throw new IllegalArgumentException();
        }
        return ResponseEntity.ok(service.findById(service.create(userCreateRequest)));
    }


}
