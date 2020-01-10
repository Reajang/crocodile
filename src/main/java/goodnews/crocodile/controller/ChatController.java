package goodnews.crocodile.controller;

import goodnews.crocodile.model.Message;
import goodnews.crocodile.model.User;
import goodnews.crocodile.services.interfaces.MessageService;
import goodnews.crocodile.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

//import org.springframework.security.core.userdetails.User;

@Controller
@RequestMapping("/goodnews/crocodile")
public class ChatController {

    private final MessageService messageService;
    private final UserService userService;
    /*@Autowired
    private AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver;*/
    @Autowired
    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/game")
    public String chatRead(Model model){
        //List<Message> messages = messageService.getAllMessages();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        List<Message> messages = messageService.allMessagesLastHour(calendar.getTime());
        model.addAttribute("messages", messages);
        return "game";
    }

    @PostMapping("/game")
    /*@AuthenticationPrincipal разобраться как пользоваться
    * Кривой AuthenticationProvider*/
    public String chatWrite(/*Principal user,*/ Message message, Model model){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByUsername(username);
        message.setAuthor(user);
        messageService.save(message);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        List<Message> messages = messageService.allMessagesLastHour(calendar.getTime());
        model.addAttribute("messages", messages);
        return "game";
    }
}
