package app.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;

//Controller without Views
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello Spring Boot!";
    }
//    http://localhost:8080/

    @RequestMapping("/date")
    public String showDate() {
        return new Date().toString();
    }
//     http://localhost:8080/date

    @RequestMapping("/nakov/new/hello")
    public int[] nakov() {
        return new int[] {1,2,3,4,5};
    }
//    http://localhost:8080/nakov/new/hello
}