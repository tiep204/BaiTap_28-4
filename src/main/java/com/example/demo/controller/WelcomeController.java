package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping("/index")
    public ModelAndView showWelcomePage(@RequestParam(name = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
