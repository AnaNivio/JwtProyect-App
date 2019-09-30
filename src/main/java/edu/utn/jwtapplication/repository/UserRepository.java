package edu.utn.jwtapplication.repository;

import edu.utn.jwtapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
