package com.example.demo.controller;


import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/run")
    public String run() throws InterruptedException {
        service.doWork();
        return "Done!";
    }
}
