package me.dawey.springdance.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "404"; // Name of your error page template
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403"; // This maps to the `403.html` template
    }
}