package com.project.sushipizzabar.users.controllers;

import com.project.sushipizzabar.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getBalanceByUserId(@RequestParam Integer id) {
        if (service.existsById(id)) {
            return ResponseEntity.ok(service.findById(id).getBalance());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
