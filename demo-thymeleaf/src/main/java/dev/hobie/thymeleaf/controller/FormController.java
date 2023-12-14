package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms")
public class FormController {

  @GetMapping("/advanced")
  public String formAdvanced() {
    return "pages/forms/advanced";
  }

  @GetMapping("/editors")
  public String formEditors() {
    return "pages/forms/editors";
  }

  @GetMapping("/general")
  public String formGeneral() {
    return "pages/forms/general";
  }

  @GetMapping("/validation")
  public String formValidation() {
    return "pages/forms/validation";
  }
}
