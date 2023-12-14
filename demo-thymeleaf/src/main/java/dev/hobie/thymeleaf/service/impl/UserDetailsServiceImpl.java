package dev.hobie.thymeleaf.service.impl;

import java.util.Collections;

import dev.hobie.thymeleaf.dto.UserDetailsDTO;
import dev.hobie.thymeleaf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {

    final var user =
        userRepository
            .findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    final var roles = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

    return UserDetailsDTO.build(user.getEmail(), user.getPassword(), roles);
  }
}
