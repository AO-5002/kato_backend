package org.example.kato.repositories;

import org.example.kato.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.authId = :auth")
    Optional<User> findByAuthId(String authId);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.authId = :auth")
    boolean existsByAuthId(String authId);
}
