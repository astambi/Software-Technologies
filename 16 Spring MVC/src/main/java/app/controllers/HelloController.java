package app.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HelloController {

    @RequestMapping("/hello") // v.1
    public String hello(Model model) {
        model.addAttribute("msg", "Hello Spring MVC + Thymeleaf!");
        model.addAttribute("date", new Date().toString());
        return "hello";
    }

    @RequestMapping("/numbers")
    public String numbers() {
        return "numbers";
    }

    @RequestMapping("/numbersplus")
    public String numbersPlus() {
        return "numbersplus";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}

//Alternatively

//@Controller
//@RequestMapping("/hello") // v.2
//public class HelloController {
//
//    @RequestMapping(method = RequestMethod.GET) // v.2
//    public String hello(Model model) {...}
//}