package com.example.bankapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Maps to templates/login.html
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Maps to templates/register.html
    }

    @GetMapping("/dashboard")
    public String showDashboardPage() {
        return "dashboard"; // Maps to templates/dashboard.html
    }
}
