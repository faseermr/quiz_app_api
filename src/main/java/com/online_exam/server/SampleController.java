package com.online_exam.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping
    public String getData(){
        return "Hello World! I am excited to learn springboot";
    }
}
