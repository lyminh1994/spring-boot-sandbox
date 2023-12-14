package dev.hobie.thymeleaf.repository;

import java.util.Optional;

import dev.hobie.thymeleaf.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
