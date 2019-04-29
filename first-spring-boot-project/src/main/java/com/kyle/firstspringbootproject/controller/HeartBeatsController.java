package com.kyle.firstspringbootproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("kyle/")
public class HeartBeatsController {
    @RequestMapping("init")
    public String init(){
        return "Hello Word!";
    }
}
