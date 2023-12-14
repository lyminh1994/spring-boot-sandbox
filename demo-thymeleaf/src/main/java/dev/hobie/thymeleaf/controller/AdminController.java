package dev.hobie.thymeleaf.controller;

import dev.hobie.thymeleaf.entity.Role;
import dev.hobie.thymeleaf.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

  private final RoleService roleService;

  @GetMapping("/roles")
  public String getRoles(Pageable pageable, Model model) {
    model.addAttribute("roles", roleService.getRoles(pageable));
    return "admin/roles";
  }

  @PostMapping("/roles")
  public String createRole(@ModelAttribute Role role) {
    log.debug("{}", role);
    return "redirect:/roles";
  }
}
