package com.example.Modul12Nivell3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/v1")
public class InitialController {
	@GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
    @GetMapping("/{name}")
    public String helloName(@PathVariable(name="name") String name) {
    	String result = "Hello, " + name;
    	
    	
    	return result;
    }
}