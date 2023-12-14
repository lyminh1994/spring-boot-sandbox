package dev.hobie.thymeleaf.service.impl;

import dev.hobie.thymeleaf.dto.RegisterDTO;
import dev.hobie.thymeleaf.entity.User;
import dev.hobie.thymeleaf.exception.ResourceNotFoundException;
import dev.hobie.thymeleaf.repository.UserRepository;
import dev.hobie.thymeleaf.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void addUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User updateUser(Long id, RegisterDTO registerRequest) {
    var user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    user.setEmail(registerRequest.email());
    user.setPassword(registerRequest.password());

    return userRepository.save(user);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
