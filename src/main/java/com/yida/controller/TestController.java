package com.yida.controller;

import com.yida.config.DictTypeIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private DictTypeIgnoreProperties dictTypeIgnoreProperties;

    @GetMapping("hello")
    public String sayHello() {
        List<String> ignores = dictTypeIgnoreProperties.getIgnores();
        System.out.println("ignores = " + ignores);

        List<Integer> ages = dictTypeIgnoreProperties.getAges();
        System.out.println("ages = " + ages);
        String name = dictTypeIgnoreProperties.getName();
        System.out.println("name = " + name);
        return "hello,world";
    }

    @GetMapping("count/{a}/{b}")
    public Double count(@PathVariable("a") double a, @PathVariable("b") double b) {
        return (a / b);
    }

    @GetMapping("test1")
    public String test1(){
        // try {
        //     Thread.sleep(1000*10);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        String s = "test1:" + UUID.randomUUID();
        // System.out.println("s = " + s);
        return s;
    }

    @GetMapping("test2")
    public String test2(){
        // try {
        //     Thread.sleep(1000*10);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        String s = "test2:" + UUID.randomUUID();
        // System.out.println("s = " + s);
        return s;
    }


}
