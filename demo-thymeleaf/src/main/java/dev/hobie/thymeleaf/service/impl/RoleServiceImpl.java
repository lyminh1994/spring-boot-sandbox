package dev.hobie.thymeleaf.service.impl;

import dev.hobie.thymeleaf.entity.Role;
import dev.hobie.thymeleaf.repository.RoleRepository;
import dev.hobie.thymeleaf.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  @Override
  public Set<Role> getRolesByName(String name) {
    return roleRepository.findAllByNameIgnoreCase(name);
  }

  @Override
  public Page<Role> getRoles(Pageable pageable) {
    return roleRepository.findAll(pageable);
  }
}
