package com.project.sushipizzabar.auth.tokens;

import com.project.sushipizzabar.users.model.auth.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public class TelephoneAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String telephone = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        if (authentication.isAuthenticated()) {
            return new TelephoneAuthenticationToken(List.of(new Role("ROLE_USER")), telephone, password);
        } else {
            throw new BadCredentialsException("with password:" + password);
        }
    }
}
