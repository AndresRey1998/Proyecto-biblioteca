package com.biblioteca.repository;

import com.biblioteca.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends JpaRepository<User, Integer> {
    User findByUserName(String nombreUsuario);
}
