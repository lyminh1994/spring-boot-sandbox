package dev.hobie.thymeleaf.service;

import dev.hobie.thymeleaf.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenuItemsByRoles(List<String> roleNames);
}
