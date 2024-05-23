package com.cycleofLife.cycleofLife.entity.dao;

import com.cycleofLife.cycleofLife.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<Users, Long> {
    Optional<Users> findByUsernameIgnoreCase(String username);

    Optional<Users> findByEmailIgnoreCase(String email);
}
