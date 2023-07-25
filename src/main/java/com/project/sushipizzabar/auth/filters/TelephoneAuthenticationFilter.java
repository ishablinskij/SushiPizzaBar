package com.project.sushipizzabar.auth.filters;

import com.project.sushipizzabar.auth.tokens.TelephoneAuthenticationToken;
import com.project.sushipizzabar.users.model.auth.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.List;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

public class TelephoneAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public TelephoneAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");

        if (telephone == null || password == null) {
            throw new IOException("telephone or password haven't be sent");
        }
        TelephoneAuthenticationToken authRequest = new TelephoneAuthenticationToken(List.of(new Role("ROLE_USER")), telephone, password);
        Authentication authentication = getAuthenticationManager().authenticate(authRequest);
        authentication.setAuthenticated(true);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        return authentication;
    }
}
