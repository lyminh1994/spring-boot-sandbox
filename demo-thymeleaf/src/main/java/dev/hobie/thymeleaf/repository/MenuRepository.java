package dev.hobie.thymeleaf.repository;

import java.util.List;

import dev.hobie.thymeleaf.entity.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
    List<Menu> findAllByRoleIdIn(List<Long> roles);

    List<Menu> findByParentIsNull();
}
