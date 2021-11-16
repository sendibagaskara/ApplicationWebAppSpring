package com.springboot.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @GetMapping("/")
    public String indexHomePage(@RequestParam(name = "name", required = false
    ,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "index";
    }
}
