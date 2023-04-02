package demo.restfulWebService.controller;

import demo.restfulWebService.model.userModel.DbUser;
import demo.restfulWebService.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String user(Model model){
        log.info("Get : user");
        Iterable<DbUser> posts = userService.findAll();
        model.addAttribute("posts", posts);
        return "user";
    }

    @GetMapping("/user/add")
    public String userAdd(Model model){
        log.info("Get : user/add");
        return "user-add";
    }

    @PostMapping("/user/add")
    public String userPostAdd(@RequestParam String login, @RequestParam String password,
                              @RequestParam String name, @RequestParam String surname,
                              @RequestParam String role, @RequestParam String position,  Model model){
        DbUser newUser = new DbUser(login, password, name, surname, role, position);
        userService.save(newUser);
        log.info("Post : user/add, save new user" + name);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable(value = "id") long id, Model model){

        model.addAttribute("post", userService.getUserInfo(id));
        log.info("Get : user/details id: " + id);
        return "user-details";
    }

    @GetMapping("/user/{id}/edit")
    public String userEdit(@PathVariable(value = "id") long id, Model model){

        model.addAttribute("post", userService.getUserInfo(id));
        log.info("Get : user/edit id: " + id);
        return "user-edit";
    }

    @PostMapping("/user/{id}/edit")
    public String userPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String name, @RequestParam String surname,
                                 @RequestParam String role, @RequestParam String position,  Model model){
        userService.userUpdate(id, name, surname, role, position);
        log.info("Post : user/edit, save new update" + name);
        return "redirect:/user";
    }

    @PostMapping("/user/{id}/remove")
    public String userPostDeleted(@PathVariable(value = "id") long id, Model model){
        userService.deleteUser(id);
        log.info("Get : user deleted id: " + id);
        return "redirect:/user";
    }
}
