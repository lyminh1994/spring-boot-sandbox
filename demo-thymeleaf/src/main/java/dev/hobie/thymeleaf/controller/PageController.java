package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

  @GetMapping("/calendar")
  public String calendar() {
    return "pages/calendar";
  }

  @GetMapping("/gallery")
  public String gallery() {
    return "pages/gallery";
  }

  @GetMapping("/kanban")
  public String kanban() {
    return "pages/kanban";
  }

  @GetMapping("/widgets")
  public String widgets() {
    return "pages/widgets";
  }
}
