package tech.digitalia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.digitalia.service.MailService;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String email(@RequestBody String emailAddress) {
        mailService.sendEmail(emailAddress.split("=")[1].replace("%40", "@"));
        return "index";
    }
}
