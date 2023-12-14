package dev.hobie.thymeleaf.controller;

import dev.hobie.thymeleaf.entity.Menu;
import dev.hobie.thymeleaf.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {

  private final MenuService menuService;

  @ModelAttribute("requestUri")
  public String getRequestServletPath(final HttpServletRequest request) {
    return request.getRequestURI();
  }

  @ModelAttribute("menus")
  public List<Menu> getMenus(@AuthenticationPrincipal UserDetails userDetails) {
    if (userDetails != null) {
      var userRoles =
          userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
      return menuService.getMenuItemsByRoles(userRoles);
    }

    return Collections.emptyList();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String exception(final Exception throwable, final Model model) {
    log.error("Exception during execution of SpringSecurity application", throwable);
    String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
    model.addAttribute("errorMessage", errorMessage);
    return "error";
  }
}
