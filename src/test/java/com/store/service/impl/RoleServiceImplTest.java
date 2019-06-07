package com.store.service.impl;

import com.store.model.Role;
import com.store.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Before
    public void setUp() throws Exception {
        roleService.deleteAllRoles();
    }

    @Test
    public void getRoleById() {
        Role role = new Role();
        role.setRole("Admin");
        roleService.addRole(role);
        assertEquals(roleService.getRoleById(roleService.getMaxId()).getRole(), "Admin");
    }
}
