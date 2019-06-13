package com.bjss.inspiration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(path = "/inspire")
    public String inspire(){
        return "dashboard";
    }
}
