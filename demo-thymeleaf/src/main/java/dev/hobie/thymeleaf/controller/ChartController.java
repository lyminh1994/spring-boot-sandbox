package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charts")
public class ChartController {

  @GetMapping("/chartjs")
  public String chartChartjs() {
    return "pages/charts/chartjs";
  }

  @GetMapping("/flot")
  public String chartFlot() {
    return "pages/charts/flot";
  }

  @GetMapping("/inline")
  public String chartInline() {
    return "pages/charts/inline";
  }

  @GetMapping("/uplot")
  public String chartUplot() {
    return "pages/charts/uplot";
  }
}
