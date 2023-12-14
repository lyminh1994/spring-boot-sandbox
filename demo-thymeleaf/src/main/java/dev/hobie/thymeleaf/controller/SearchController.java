package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

  @GetMapping("/enhanced")
  public String searchEnhanced() {
    return "pages/search/enhanced";
  }

  @GetMapping("/enhanced-results")
  public String searchEnhancedResults() {
    return "pages/search/enhanced-results";
  }

  @GetMapping("/simple")
  public String searchSimple() {
    return "pages/search/simple";
  }

  @GetMapping("/simple-results")
  public String searchSimpleResults() {
    return "pages/search/simple-results";
  }
}
