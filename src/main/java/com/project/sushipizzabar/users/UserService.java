package com.project.sushipizzabar.users;

import com.project.sushipizzabar.basket.BasketService;
import com.project.sushipizzabar.basket.model.Basket;
import com.project.sushipizzabar.users.dao.UserRepository;
import com.project.sushipizzabar.users.dto.UserCreateRequest;
import com.project.sushipizzabar.users.dto.UserDto;
import com.project.sushipizzabar.users.mappers.UserMapper;
import com.project.sushipizzabar.users.model.User;
import com.project.sushipizzabar.users.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    private final BasketService basketService;

    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(mapper::toDto)
                .get();
    }

    @Transactional
    public Integer create(UserCreateRequest createRequest) {
        User user = mapper.toUser(createRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        basketService.create(user);
        return savedUser.getId();
    }

}
