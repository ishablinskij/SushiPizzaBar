package com.project.sushipizzabar.users.controllers;

import com.project.sushipizzabar.basket.dao.BasketRepository;
import com.project.sushipizzabar.users.UserService;
import com.project.sushipizzabar.users.dao.UserRepository;
import com.project.sushipizzabar.basket.model.Basket;
import com.project.sushipizzabar.users.dto.UserCreateRequest;
import com.project.sushipizzabar.users.model.User;
import com.project.sushipizzabar.users.dto.UserDto;
import com.project.sushipizzabar.users.mappers.UserMapper;
import com.project.sushipizzabar.users.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(service.findById(service.create(userCreateRequest)));
    }


}
