package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/send")
public class SendFinishedController {

    @RequestMapping("")
    public String index(){
        return "send";
    }
    
}
