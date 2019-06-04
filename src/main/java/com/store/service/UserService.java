package com.store.service;

import com.store.model.Product;
import com.store.model.User;

public interface UserService {

    void createUser(User user);

    void changeUser(User user);

    void deleteUserById(Integer id);

    User findUserByEmail (String email);

    Iterable<User> getAllUsers();
}
