package com.pickmyfruit.controller;  // ✅ Use your actual base package structure
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // ✅ This will return login.html from templates folder
    }
}
