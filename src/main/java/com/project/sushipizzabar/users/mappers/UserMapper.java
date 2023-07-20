package com.project.sushipizzabar.users.mappers;

import com.project.sushipizzabar.users.dto.userDto.UserCreateRequest;
import com.project.sushipizzabar.users.dto.userDto.UserSignInRequest;
import com.project.sushipizzabar.users.model.User;
import com.project.sushipizzabar.users.dto.userDto.UserDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserMapper {

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setBalance(userDto.getBalance());
        user.setTelephone(userDto.getTelephone());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setBalance(user.getBalance());
        userDto.setTelephone(user.getTelephone());
        return userDto;
    }

    public UserDto toDto(UserCreateRequest createRequest) {
        UserDto userDto = new UserDto();
        userDto.setBalance(BigDecimal.ZERO);
        userDto.setName(createRequest.getName());
        userDto.setTelephone(createRequest.getTelephone());
        userDto.setPassword(createRequest.getPassword());
        return userDto;
    }

    public User toUser(UserCreateRequest createRequest) {
        User user = new User();
        user.setBalance(BigDecimal.ZERO);
        user.setName(createRequest.getName());
        user.setTelephone(createRequest.getTelephone());
        user.setPassword(createRequest.getPassword());
        return user;
    }

    public UserDto toDto(UserSignInRequest signInRequest) {
        UserDto userDto = new UserDto();
        userDto.setBalance(BigDecimal.ZERO);
        userDto.setTelephone(signInRequest.getTelephone());
        userDto.setPassword(signInRequest.getPassword());
        return userDto;
    }

    public User toUser(UserSignInRequest signInRequest) {
        User user = new User();
        user.setBalance(BigDecimal.ZERO);
        user.setTelephone(signInRequest.getTelephone());
        user.setPassword(signInRequest.getPassword());
        return user;
    }

}
