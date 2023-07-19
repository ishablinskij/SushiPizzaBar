package com.project.sushipizzabar.users;

import com.project.sushipizzabar.basket.BasketService;
import com.project.sushipizzabar.users.dao.AddressRepository;
import com.project.sushipizzabar.users.dao.UserRepository;
import com.project.sushipizzabar.users.dto.UserCreateRequest;
import com.project.sushipizzabar.users.dto.UserDto;
import com.project.sushipizzabar.users.mappers.AddressMapper;
import com.project.sushipizzabar.users.mappers.UserMapper;
import com.project.sushipizzabar.users.model.Address;
import com.project.sushipizzabar.users.model.User;
import com.project.sushipizzabar.users.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    private final BasketService basketService;

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .get();
    }

    @Transactional
    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Transactional
    public Integer create(UserCreateRequest createRequest) {
        User user = userMapper.toUser(createRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        Address address = addressMapper.toAddress(createRequest.getAddress());
        address.setUser(savedUser);

        addressRepository.save(address);

        basketService.create(user);
        return savedUser.getId();
    }

}
