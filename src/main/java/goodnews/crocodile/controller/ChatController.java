package goodnews.crocodile.controller;

import goodnews.crocodile.model.Message;
import goodnews.crocodile.model.User;
import goodnews.crocodile.services.interfaces.MessageService;
import goodnews.crocodile.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodnews/crocodile")
public class ChatController {

    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/game")
    public String chatRead(Model model){
        List<Message> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "game";
    }

    @PostMapping("/game")
    public String chatWrite(@AuthenticationPrincipal User user, Message message, Model model){

        //user.getMessages().add(message);
        message.setAuthor(user);

        messageService.save(message);

        model.addAttribute("messages", messageService.getAllMessages());

        return "game";
    }
}
