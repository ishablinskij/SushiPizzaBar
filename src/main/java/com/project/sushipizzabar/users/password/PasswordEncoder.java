package com.project.sushipizzabar.users.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    public PasswordEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String password) {
        String pass = password;
        pass = encoder.encode(pass);
        return pass;
    }

    public boolean matches(String password, String result){
        return encoder.matches(password, result);
    }

}
