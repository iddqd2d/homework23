package com.store.service;

import com.store.model.Role;

public interface RoleService {
    Role findByRole(String role);

    void deleteAllRoles();

    Integer getMaxId();

    Role getRoleById(Integer id);

    void addRole (Role role);
}
