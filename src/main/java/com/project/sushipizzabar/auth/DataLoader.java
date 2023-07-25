package com.project.sushipizzabar.auth;

import com.project.sushipizzabar.users.dao.PrivilegeRepository;
import com.project.sushipizzabar.users.dao.RoleRepository;
import com.project.sushipizzabar.users.model.auth.Privilege;
import com.project.sushipizzabar.users.model.auth.Role;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;



    @Override
    public void onApplicationEvent(@Nonnull ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        Privilege basketPrivilege = privilegeRepository.save(new Privilege("BASKET_PRIVILEGE"));
        if (roleRepository.existsById(1))
            roleRepository.save(new Role("ROLE_USER", List.of(basketPrivilege)));
        if (roleRepository.existsById(2))
            roleRepository.save(new Role("ROLE_ADMIN", List.of(basketPrivilege)));

        alreadySetup = true;
    }
}
