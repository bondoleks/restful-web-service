package demo.restfulWebService.controller;

import demo.restfulWebService.model.messageModel.Message;
import demo.restfulWebService.model.userModel.DbUser;
import demo.restfulWebService.service.MessageService;
import demo.restfulWebService.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@Log4j2
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/chat")
    public String userEdit(Model model){
        model.addAttribute("post", messageService.findAll());
        log.info("Get : chat");
        return "chat";
    }

    @PostMapping("/chat")
    public String userPostUpdate(@RequestParam String message,  Model model){
        String localDateTime = String.valueOf(LocalDateTime.now());
        // Add info from User
        Message newMessage = new Message(1l, localDateTime + message);
        messageService.save(newMessage);
        log.info("Post : chat message " + message);
        return "redirect:/chat";
    }

}
