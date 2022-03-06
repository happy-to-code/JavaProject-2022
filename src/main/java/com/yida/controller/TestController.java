package com.yida.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("hello")
    public String sayHello() {
        String s = "";
        s = null;
        System.out.println(s.length());
        return "hello,world";
    }

    @GetMapping("count/{a}/{b}")
    public Double count(@PathVariable("a") double a, @PathVariable("b") double b) {
        return (a / b);
    }


}
