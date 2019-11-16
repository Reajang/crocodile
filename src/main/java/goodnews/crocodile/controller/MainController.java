package goodnews.crocodile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodnews/crocodile")
public class MainController {

    @GetMapping("/game")
    public String paint(Model model){
        return "game";
    }
    @GetMapping
    public String mainScreen(Model model){
        return "main";
    }
}
