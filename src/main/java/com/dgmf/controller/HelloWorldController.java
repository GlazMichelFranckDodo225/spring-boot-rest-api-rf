package com.dgmf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

// Makes this Class as "Spring MVC" Controller
@Controller
// The returned Java Object is automatically convert
// into JSON Object and passed back into the HttpResponse Object
@ResponseBody
public class HelloWorldController {
}
