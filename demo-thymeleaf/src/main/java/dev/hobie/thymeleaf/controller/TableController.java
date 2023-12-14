package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
public class TableController {

  @GetMapping("/data")
  public String tableData() {
    return "pages/tables/data";
  }

  @GetMapping("/jsgrid")
  public String tableJsGrid() {
    return "pages/tables/jsgrid";
  }

  @GetMapping("/simple")
  public String tableSimple() {
    return "pages/tables/simple";
  }
}
