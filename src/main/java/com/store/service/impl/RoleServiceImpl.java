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

    @Override
    public void deleteAllRoles() {
        repository.deleteAll();
    }

    @Override
    public Integer getMaxId() {
        return repository.getMaxId();
    }

    @Override
    public Role getRoleById(Integer id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void addRole(Role role) {
        repository.save(role);
    }
}
