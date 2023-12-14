package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/examples")
public class ExampleController {

  @GetMapping("/404")
  public String example404() {
    return "pages/examples/404";
  }

  @GetMapping("/500")
  public String example500() {
    return "pages/examples/500";
  }

  @GetMapping("/contact-us")
  public String exampleContactUs() {
    return "pages/examples/contact-us";
  }

  @GetMapping("/contacts")
  public String exampleContacts() {
    return "pages/examples/contacts";
  }

  @GetMapping("/e-commerce")
  public String exampleEcommerce() {
    return "pages/examples/e-commerce";
  }

  @GetMapping("/faq")
  public String exampleFaq() {
    return "pages/examples/faq";
  }

  @GetMapping("/invoice")
  public String exampleInvoice() {
    return "pages/examples/invoice";
  }

  @GetMapping("/invoice-print")
  public String exampleInvoicePrint() {
    return "pages/examples/invoice-print";
  }

  @GetMapping("/profile")
  public String exampleProfile() {
    return "pages/examples/profile";
  }

  @GetMapping("/project-add")
  public String exampleProjectAdd() {
    return "pages/examples/project-add";
  }

  @GetMapping("/project-detail")
  public String exampleProjectDetail() {
    return "pages/examples/project-detail";
  }

  @GetMapping("/project-edit")
  public String exampleProjectEdit() {
    return "pages/examples/project-edit";
  }

  @GetMapping("/projects")
  public String exampleProjects() {
    return "pages/examples/projects";
  }
}
