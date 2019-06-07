package com.store.service.impl;

import com.store.model.User;
import com.store.service.RoleService;
import com.store.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Before
    public void setUp() throws Exception {
        userService.deleteAllUsers();
    }

    @Test
    public void createUser() {
        User user = new User()
                .setFirstName("First")
                .setLastName("Last")
                .setActive(true)
                .setEmail("test@gmail.com")
                .setPassword("11111");
        userService.createUser(user);
        assertEquals("First", userService.getUserById(userService.getMaxId()).getFirstName());
    }

    @Test
    public void changeUser() {
        User user = new User()
                .setFirstName("First")
                .setLastName("Last")
                .setActive(true)
                .setEmail("test@gmail.com")
                .setPassword("11111");
        userService.createUser(user);
        user.setFirstName("Test");
        userService.changeUser(user);
        assertEquals("Test", userService.getUserById(userService.getMaxId()).getFirstName());
    }

    @Test
    public void deleteUserById() {
        User user = new User()
                .setFirstName("First")
                .setLastName("Last")
                .setActive(true)
                .setEmail("test@gmail.com")
                .setPassword("11111");
        userService.createUser(user);
        userService.deleteUserById(userService.getMaxId());
        assertFalse(Objects.nonNull(userService.getMaxId()));
    }
}
