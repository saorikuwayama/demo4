package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/finished")
public class RegisterFinishedController {
    @RequestMapping("")
    public String index(){
        return "finished";
    }
}
