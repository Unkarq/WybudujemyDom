package com.wybudujemydom.wd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
//    @Autowired
//    private AppUserService appUserService;


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}