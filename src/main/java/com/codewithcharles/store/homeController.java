package com.codewithcharles.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class homeController {

    @RequestMapping("/")
    public String index() {
        return "login"; // Displays login.html
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {

        // Simple hardcoded validation (for demo)
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("name", username);
            return "welcome"; // Show welcome.html
        } else {
            model.addAttribute("error", "Invalid credentials!");
            return "login"; // Return back to login with error
        }
    }
}
