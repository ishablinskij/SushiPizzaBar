package com.project.sushipizzabar.basket;

import com.project.sushipizzabar.basket.dao.BasketRepository;
import com.project.sushipizzabar.basket.dto.BasketDto;
import com.project.sushipizzabar.food.dto.FoodCreateRequest;
import com.project.sushipizzabar.basket.mappers.BasketMapper;
import com.project.sushipizzabar.basket.model.Basket;
import com.project.sushipizzabar.users.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    private final BasketMapper mapper;


    @Transactional
    public BasketDto findById(Integer id) {
        return basketRepository.findById(id)
                .map(mapper::toDto)
                .get();
    }

    @Transactional
    public Integer create(User user) {
        Basket basket = new Basket();
        basket.setUser(user);
        Basket savedBasket = basketRepository.save(basket);
        return savedBasket.getId();
    }

    @Transactional
    public Integer addFood(FoodCreateRequest createRequest) {
        Basket basket = basketRepository.findById(createRequest.getBasketId());
        basket.addFood(createRequest.getFood());
        Basket savedBasket = basketRepository.save(basket);
        return savedBasket.getId();
    }

}
