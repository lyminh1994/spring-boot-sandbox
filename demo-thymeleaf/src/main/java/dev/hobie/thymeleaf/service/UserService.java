package dev.hobie.thymeleaf.service;

import dev.hobie.thymeleaf.dto.RegisterDTO;
import dev.hobie.thymeleaf.entity.User;

public interface UserService {

  void addUser(User user);

  User getUser(Long id);

  Iterable<User> getUsers();

  User updateUser(Long id, RegisterDTO registerRequest);

  void deleteUser(Long id);
}
