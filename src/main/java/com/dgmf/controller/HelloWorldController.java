package com.dgmf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller ==> Makes this Class as "Spring MVC" Controller
// @ResponseBody ==> The returned Java Object is automatically convert
// into JSON Object and passed back into the HttpResponse Object
@RestController // Combination of "@Controller" and "@ResponseBody" Annotations
public class HelloWorldController {
    // Http Get Request
    // Map Http Get Request onto specific Handler Method
    @GetMapping("/hello-world") // http://localhost:8080/hello-world
    public String helloWorld() {
        return "Hello world !";
    }
}
