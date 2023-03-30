package demo.restfulWebService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class UserController {

    @GetMapping("/user")
    public String user(Model model){
        log.info("Get : user");
//        Iterable<DbUser> posts = postService.findAll();
//        model.addAttribute("posts", posts);
        return "user";
    }

    @GetMapping("/user/add")
    public String blogAdd(Model model){
        return "user-add";
    }

    @PostMapping("/user/add")
    public String blogPostAdd(@RequestParam String name, @RequestParam String surname, @RequestParam String full_text, Model model){

        return "redirect:/blog";
    }

}
