package com.store.repository;

import com.store.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(String role);

    @Query(value = "SELECT MAX(id) FROM roles", nativeQuery = true)
    Integer getMaxId();
}
