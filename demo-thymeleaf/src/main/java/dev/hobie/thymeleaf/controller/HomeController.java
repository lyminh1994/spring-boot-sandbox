package dev.hobie.thymeleaf.controller;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

  private final FreeMarkerConfig freeMarkerConfig;

  @GetMapping("/")
  public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
    try {
      var templateModel = new HashMap<String, Object>();
      templateModel.put("username", userDetails.getUsername());
      var template = freeMarkerConfig.getConfiguration().getTemplate("Entity.ftl");
      var result = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel);
      model.addAttribute("freemarker", result);
    } catch (IOException | TemplateException e) {
      log.error("Parse Template error", e);
    }

    return "index";
  }
}
