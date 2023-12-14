package dev.hobie.thymeleaf.service;

import dev.hobie.thymeleaf.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface RoleService {

    Set<Role> getRolesByName(String name);

    Page<Role> getRoles(Pageable pageable);
}
