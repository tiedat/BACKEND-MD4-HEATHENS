package com.heathens.music.repository;

import com.heathens.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsernameIgnoreCase(String username);
}
