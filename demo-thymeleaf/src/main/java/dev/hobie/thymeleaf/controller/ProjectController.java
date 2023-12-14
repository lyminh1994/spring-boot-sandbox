package dev.hobie.thymeleaf.controller;

import java.util.stream.IntStream;

import dev.hobie.thymeleaf.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping
  public String getProjects(Model model, Pageable pageable) {
    var projects = projectService.getProjects(pageable);
    int totalPages = projects.getTotalPages();
    if (totalPages > 0) {
      var pageNumbers = IntStream.rangeClosed(1, 5).boxed().toList();
      model.addAttribute("pageNumbers", pageNumbers);
    }
    model.addAttribute("projects", projects);

    return "projects/index";
  }

  @GetMapping("/detail")
  public String getProjectsDetail() {
    return "projects/detail";
  }

  @GetMapping("/add")
  public String getProjectsAdd() {
    return "projects/create";
  }

  @GetMapping("/edit")
  public String getProjectsEdit() {
    return "projects/edit";
  }
}
