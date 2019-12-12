package goodnews.crocodile.controller;

import goodnews.crocodile.model.Message;
import goodnews.crocodile.model.User;
import goodnews.crocodile.model.statusEnum.UserRole;
import goodnews.crocodile.services.interfaces.MessageService;
import goodnews.crocodile.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goodnews/crocodile")
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(User user){
        user.getRole().add(UserRole.USER);
        userService.save(user);
        return "redirect:/goodnews/crocodile";
    }


}
