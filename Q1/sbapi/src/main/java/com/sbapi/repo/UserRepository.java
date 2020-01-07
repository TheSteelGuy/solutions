package com.sbapi.repo;

import com.sbapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByEmail(String email);

}
