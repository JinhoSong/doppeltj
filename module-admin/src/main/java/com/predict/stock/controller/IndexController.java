package com.predict.stock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("message","hello user");
        }
        else {
            model.addAttribute("message", principal.getName());
        }
        return "index";
    }


    @GetMapping("/info")
    public String info(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("message","hello info");
        }
        else {
            model.addAttribute("message", principal.getName());
        }
        return "info";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("message","hello admin");
        }
        else {
            model.addAttribute("message", principal.getName());
        }
        return "admin";
    }

}
