package com.project.sushipizzabar.users.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    public PasswordEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public char[] encode(char[] password) {
        CharSequence pass = new String(password);
        pass = encoder.encode(pass);
        return pass.toString().toCharArray();
    }

    public boolean matches(char[] password, char[] result){
        return encoder.matches(new String(password), new String(result));
    }

}
