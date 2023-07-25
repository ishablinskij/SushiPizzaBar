package com.project.sushipizzabar.users;

import com.project.sushipizzabar.auth.exceptions.UserAlreadyExistsException;
import com.project.sushipizzabar.basket.BasketService;
import com.project.sushipizzabar.basket.dto.BasketDto;
import com.project.sushipizzabar.users.dao.AddressRepository;
import com.project.sushipizzabar.users.dao.RoleRepository;
import com.project.sushipizzabar.users.dao.UserRepository;
import com.project.sushipizzabar.users.dto.userDto.UserCreateRequest;
import com.project.sushipizzabar.users.dto.userDto.UserDto;
import com.project.sushipizzabar.users.dto.userDto.UserSignInRequest;
import com.project.sushipizzabar.users.mappers.AddressMapper;
import com.project.sushipizzabar.users.mappers.UserMapper;
import com.project.sushipizzabar.users.model.Address;
import com.project.sushipizzabar.users.model.User;
import com.project.sushipizzabar.users.password.SimplePasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;

    private final BasketService basketService;

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    private final SimplePasswordEncoder passwordEncoder;


    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .get();
    }

    public UserDto findByTelephone(String telephone) {
        return userMapper.toDto(userRepository.findByTelephone(telephone)) ;
    }

    public boolean basketExists(int id) {
        User user = userRepository.findById(id);
        int basketId = user.getBasket().getId();

        return basketService.existsById(basketId);
    }

    public BasketDto getBasketByUserId(int id) {
        User user = userRepository.findById(id);
        int basketId = user.getBasket().getId();

        return basketService.findById(id);
    }


    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    public boolean existsByTelephone(String telephone) {
        return userRepository.existsByTelephone(telephone);
    }

    public Integer create(UserCreateRequest createRequest) {

        if (userRepository.existsByTelephone(createRequest.getTelephone())) {
            throw new UserAlreadyExistsException();
        }

        User user = userMapper.toUser(createRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new ArrayList<>());
        user.addRole(roleRepository.findByName("ROLE_USER"));
        User savedUser = userRepository.save(user);

        Address address = addressMapper.toAddress(createRequest.getAddress());
        address.setUser(savedUser);

        addressRepository.save(address);

        basketService.create(user);
        return savedUser.getId();
    }

    public boolean match(UserDto userDto, UserSignInRequest signInRequest) {
        String dbPassword = userDto.getPassword();
        String requestPassword = signInRequest.getPassword();
        return passwordEncoder.matches(requestPassword, dbPassword);
    }

    public boolean match(String rawPassword, String encodePassword) {
        return passwordEncoder.matches(rawPassword, encodePassword);
    }

    public UserDto badRequest() {
        return new UserDto();
    }

}
