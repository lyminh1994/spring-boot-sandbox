package dev.hobie.thymeleaf.service.impl;

import dev.hobie.thymeleaf.repository.RoleRepository;
import dev.hobie.thymeleaf.entity.Menu;
import dev.hobie.thymeleaf.repository.MenuRepository;
import dev.hobie.thymeleaf.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

  private final MenuRepository menuRepository;
  private final RoleRepository roleRepository;

  @Override
  public List<Menu> getMenuItemsByRoles(List<String> roleNames) {
    /*var roles = roleRepository.findAllByNameIn(roleNames);
    return menuRepository.findAllByRoles(roles);*/

    return menuRepository.findByParentIsNull();
  }
}
