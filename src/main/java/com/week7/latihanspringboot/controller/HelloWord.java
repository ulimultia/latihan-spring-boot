package com.week7.latihanspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
    @GetMapping("/hello-world")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s", name);
    }
}
