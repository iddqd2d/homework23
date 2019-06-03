package com.store.service.impl;

import com.store.model.User;
import com.store.repository.UserRepository;
import com.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void createUser(User user) {
        repository.save(user);
    }

    @Override
    public void changeUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }
}
