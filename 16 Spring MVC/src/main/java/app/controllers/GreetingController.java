package app.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(value = "name", defaultValue = "Stranger") String personName,
            Model model) {
        model.addAttribute("personToGreet", personName);
        return "greeting";
    }
}