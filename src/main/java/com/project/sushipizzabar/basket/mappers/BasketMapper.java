package com.project.sushipizzabar.basket.mappers;

import com.project.sushipizzabar.basket.dto.BasketDto;
import com.project.sushipizzabar.food.dto.FoodCreateRequest;
import com.project.sushipizzabar.basket.model.Basket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketMapper {

    public Basket toBasket(BasketDto basketDto) {
        Basket basket = new Basket();
        basket.setUser(basketDto.getUser());
        basket.setFoods(basketDto.getFoods());
        basket.setId(basketDto.getId());
        return basket;
    }

    public BasketDto toDto(Basket basket) {
        BasketDto basketDto = new BasketDto();
        basketDto.setUser(basket.getUser());
        basketDto.setFoods(basket.getFoods());
        basketDto.setId(basket.getId());
        return basketDto;
    }

    public Basket toBasket(FoodCreateRequest createRequest) {
        Basket basket = new Basket();
        basket.setId(createRequest.getBasketId());
        basket.setFoods(new ArrayList<>());
        basket.addFood(createRequest.getFood());
        return basket;
    }

    public BasketDto toDto(FoodCreateRequest createRequest) {
        BasketDto basketDto = new BasketDto();
        basketDto.setId(createRequest.getBasketId());
        basketDto.setFoods(new ArrayList<>(List.of(createRequest.getFood())));
        return basketDto;
    }

}
