package it.sevenbits.hellospring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello from HelloWorldController!";
    }

}
