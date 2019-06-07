package com.store.service.impl;

import com.store.model.Role;
import com.store.model.User;
import com.store.repository.UserRepository;
import com.store.service.RoleService;
import com.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private static final String ROLE = "USER";
    private final UserRepository repository;
    private final RoleService roleService;

    @Override
    public void createUser(User user) {
        Role userRole = roleService.findByRole(ROLE);
        user
            .setActive(true)
            .setRoles(new HashSet<>(Arrays.asList(userRole)));
        repository.save(user);
    }

    @Override
    public void changeUser(User user) {
        Role userRole = roleService.findByRole(ROLE);
        user
                .setActive(true)
                .setRoles(new HashSet<>(Arrays.asList(userRole)));
        repository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteAllUsers() {
        repository.deleteAll();
    }

    @Override
    public Integer getMaxId() {
        return repository.getMaxId();
    }
}
