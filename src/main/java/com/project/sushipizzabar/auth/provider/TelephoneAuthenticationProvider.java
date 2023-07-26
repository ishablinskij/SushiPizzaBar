package com.project.sushipizzabar.auth.provider;

import com.project.sushipizzabar.auth.TelephoneUserDetailsManager;
import com.project.sushipizzabar.auth.tokens.TelephoneAuthenticationToken;
import com.project.sushipizzabar.users.password.SimplePasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TelephoneAuthenticationProvider implements AuthenticationProvider {

    private final TelephoneUserDetailsManager userService;

    private final SimplePasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String telephone = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserDetails u = userService.loadUserByUsername(telephone);

        if (passwordEncoder.matches(password, u.getPassword())) {
            return new TelephoneAuthenticationToken(
                    u.getAuthorities(),
                    telephone,
                    password);
        }

        throw new BadCredentialsException("Bad credentials!");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication
                .equals(UsernamePasswordAuthenticationToken.class);
    }
}
