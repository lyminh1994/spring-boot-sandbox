package dev.hobie.thymeleaf.controller;

import dev.hobie.thymeleaf.dto.RegisterDTO;
import dev.hobie.thymeleaf.entity.User;
import dev.hobie.thymeleaf.service.RoleService;
import dev.hobie.thymeleaf.service.UserService;
import jakarta.validation.Valid;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {

  private final PasswordEncoder passwordEncoder;

  private final UserService userService;

  private final RoleService roleService;

  private final MessageSource messageSource;

  @RequestMapping("/register")
  public String getRegister(
      @Valid @ModelAttribute RegisterDTO registerRequest, BindingResult result, Model model) {
    try {
      if (result.hasErrors()) {
        model.addAttribute("user", registerRequest);
        return "/auth/register-v2";
      }
      var role = roleService.getRolesByName("ROLE_USER");
      var user =
          new User(
              registerRequest.fullname(),
              registerRequest.email(),
              passwordEncoder.encode(registerRequest.password()),
              role);
      userService.addUser(user);
      return "redirect:/login";
    } catch (Exception ex) {
      model.addAttribute("registerError", ex.getMessage());
    }

    model.addAttribute("user", RegisterDTO.builder().build());
    return "/auth/register-v2";
  }

  @GetMapping("/login")
  public String getLogin(
      @RequestParam(required = false) final Boolean required,
      @RequestParam(required = false) final Boolean error,
      @RequestParam(required = false) final Boolean success,
      Model model,
      Locale locale) {
    if (required == Boolean.TRUE) {
      model.addAttribute(
          "required", messageSource.getMessage("authentication.login.required", null, locale));
    }
    if (error == Boolean.TRUE) {
      model.addAttribute(
          "error", messageSource.getMessage("authentication.login.error", null, locale));
    }
    if (success == Boolean.TRUE) {
      model.addAttribute(
          "success", messageSource.getMessage("authentication.logout.success", null, locale));
    }

    return "/auth/login-v2";
  }

  @GetMapping("/forgot-password")
  public String forgotPassword(){
    return "/auth/forgot-password-v2";
  }
}
