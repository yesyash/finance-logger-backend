package com.example.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO : remove this ASAP
@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return  "Greetings! Hello World!";
    }
}
