package com.softnovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {
    @RequestMapping("/index")
    public static String index() {
        return "index";
    }

}
