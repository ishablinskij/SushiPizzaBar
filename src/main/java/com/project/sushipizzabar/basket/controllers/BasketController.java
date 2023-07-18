package com.project.sushipizzabar.basket.controllers;

import com.project.sushipizzabar.basket.BasketService;
import com.project.sushipizzabar.basket.dao.BasketRepository;
import com.project.sushipizzabar.basket.model.Basket;
import com.project.sushipizzabar.basket.dto.BasketDto;
import com.project.sushipizzabar.basket.dto.FoodCreateRequest;
import com.project.sushipizzabar.basket.mappers.BasketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService service;

    @PostMapping
    public ResponseEntity<BasketDto> addFood(@RequestBody FoodCreateRequest foodCreateRequest) {
        return ResponseEntity.ok(service.findById(service.addFood(foodCreateRequest)));
    }
}
