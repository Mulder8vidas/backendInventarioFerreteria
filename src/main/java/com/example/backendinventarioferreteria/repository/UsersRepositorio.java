package com.example.backendinventarioferreteria.repository;
import com.example.backendinventarioferreteria.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepositorio extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
