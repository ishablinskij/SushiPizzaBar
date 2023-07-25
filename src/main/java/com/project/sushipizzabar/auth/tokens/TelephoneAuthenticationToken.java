package com.project.sushipizzabar.auth.tokens;

import com.project.sushipizzabar.auth.UserDetailsRegistrationService;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

    public class TelephoneAuthenticationToken extends AbstractAuthenticationToken {

    private String telephone;
    private String password;

    public TelephoneAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public TelephoneAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String telephone, String password) {
        super(authorities);
        setAuthenticated(true);
        this.telephone = telephone;
        this.password = password;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getPrincipal() {
        return this.telephone;
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
