package com.project.sushipizzabar.auth;

import com.project.sushipizzabar.auth.user.SecurityUser;
import com.project.sushipizzabar.users.UserService;
import com.project.sushipizzabar.users.dao.RoleRepository;
import com.project.sushipizzabar.users.dao.UserRepository;
import com.project.sushipizzabar.users.model.User;
import com.project.sushipizzabar.users.model.auth.Privilege;
import com.project.sushipizzabar.users.model.auth.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsRegistrationService implements UserDetailsManager {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String telephone) throws UsernameNotFoundException {
        User user = userRepository.findByTelephone(telephone);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + telephone);
        }

        return new SecurityUser(user);
    }

    private List<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }


    private List<String> getPrivileges(List<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Override
    public void createUser(UserDetails user) {
        //TODO
    }

    @Override
    public void updateUser(UserDetails user) {
        //TODO
    }

    @Override
    public void deleteUser(String username) {
        //TODO
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        //TODO
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByTelephone(username);
    }
}
