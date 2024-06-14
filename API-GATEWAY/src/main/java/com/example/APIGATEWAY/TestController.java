package com.example.APIGATEWAY;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hello world")
    public String helloWorld(){
        return "Hello world";
    }
}
