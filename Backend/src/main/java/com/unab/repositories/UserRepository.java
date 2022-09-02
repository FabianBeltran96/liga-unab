package com.unab.repositories;

import com.unab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query(nativeQuery = true, value="SELECT * FROM users WHERE id=:id")
    public User findUserById(Long id);
}
