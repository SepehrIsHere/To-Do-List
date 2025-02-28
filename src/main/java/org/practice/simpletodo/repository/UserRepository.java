package org.practice.simpletodo.repository;

import org.practice.simpletodo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(@Param("userName") String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    Optional<User> loginWithUsername(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> loginWithEmail(@Param("email") String email, @Param("password") String password);
}
