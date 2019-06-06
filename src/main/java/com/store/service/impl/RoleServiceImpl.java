package com.store.service.impl;

import com.store.model.Role;
import com.store.repository.RoleRepository;
import com.store.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role findByRole(String role) {
        return repository.findByRole(role).orElse(new Role());
    }
}
