package com.visa.ecomapp.security.repo;



import com.visa.ecomapp.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
