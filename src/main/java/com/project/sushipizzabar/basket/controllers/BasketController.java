package com.project.sushipizzabar.basket.controllers;

import com.project.sushipizzabar.basket.BasketService;
import com.project.sushipizzabar.basket.dto.BasketDto;
import com.project.sushipizzabar.food.dto.FoodCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @PostMapping
    public ResponseEntity<BasketDto> addFood(@RequestBody FoodCreateRequest foodCreateRequest) {
        return ResponseEntity.ok(service.findById(service.addFood(foodCreateRequest)));
    }
}
