package com.project.sushipizzabar.users.controllers;

import com.project.sushipizzabar.users.UserService;
import com.project.sushipizzabar.users.dto.userDto.UserDto;
import com.project.sushipizzabar.users.dto.userDto.UserSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class SignInController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> login(@RequestParam String telephone, @RequestParam String password) {
        if (service.existsByTelephone(telephone)) {
            UserDto userDto = service.findByTelephone(telephone);
            if (service.match(password, userDto.getPassword())) {
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
