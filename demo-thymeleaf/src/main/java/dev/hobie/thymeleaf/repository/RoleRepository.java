package dev.hobie.thymeleaf.repository;

import dev.hobie.thymeleaf.entity.Role;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Set<Role> findAllByNameIgnoreCase(String name);
}
