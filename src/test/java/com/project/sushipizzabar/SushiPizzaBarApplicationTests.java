package com.project.sushipizzabar;

import com.project.sushipizzabar.users.password.SimplePasswordEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SushiPizzaBarApplicationTests {

    @Test
    void testEncoding() {
        SimplePasswordEncoder passwordEncoder = new SimplePasswordEncoder();
        String pass = passwordEncoder.encode("password");
        System.out.println(pass);
        Assertions.assertTrue(passwordEncoder.matches("password", pass));

    }

}
