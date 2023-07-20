package com.project.sushipizzabar.users.controllers;

import com.project.sushipizzabar.users.UserService;
import com.project.sushipizzabar.users.dto.userDto.UserDto;
import com.project.sushipizzabar.users.dto.userDto.UserSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class SignInController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> login(UserSignInRequest userSignInRequest) {
        if (service.existsByTelephone(userSignInRequest.getTelephone())) {
            UserDto userDto = service.findByTelephone(userSignInRequest.getTelephone());
            if (Arrays.equals(userDto.getPassword(), userSignInRequest.getPassword())) {
                return ResponseEntity.ok(userDto);
            } else {
                return ResponseEntity.badRequest()
                        .body(service.badRequest());
            }
        } else {
            return ResponseEntity.badRequest()
                    .body(service.badRequest());

        }
    }

}
