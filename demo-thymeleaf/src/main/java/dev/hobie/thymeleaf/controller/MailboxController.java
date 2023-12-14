package dev.hobie.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mailbox")
public class MailboxController {

  @GetMapping("/compose")
  public String mailboxCompose() {
    return "pages/mailbox/compose";
  }

  @GetMapping("/mailbox")
  public String mailbox() {
    return "pages/mailbox/mailbox";
  }

  @GetMapping("/read-mail")
  public String mailboxReadMail() {
    return "pages/mailbox/read-mail";
  }
}
