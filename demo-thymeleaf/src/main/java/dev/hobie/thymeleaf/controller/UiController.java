package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/UI")
public class UiController {

  @GetMapping("/buttons")
  public String uiButtons() {
    return "pages/UI/buttons";
  }

  @GetMapping("/general")
  public String uiGeneral() {
    return "pages/UI/general";
  }

  @GetMapping("/icons")
  public String uiIcons() {
    return "pages/UI/icons";
  }

  @GetMapping("/modals")
  public String uiModals() {
    return "pages/UI/modals";
  }

  @GetMapping("/ribbons")
  public String uiRibbons() {
    return "pages/UI/ribbons";
  }

  @GetMapping("/sliders")
  public String uiSliders() {
    return "pages/UI/sliders";
  }

  @GetMapping("/timeline")
  public String uiTimeline() {
    return "pages/UI/timeline";
  }
}
