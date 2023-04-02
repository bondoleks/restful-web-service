package demo.restfulWebService.controller;

import demo.restfulWebService.model.projectModel.Task;
import demo.restfulWebService.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Log4j2
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/task")
    public String task(Model model){
        log.info("Get : tasks");
        Iterable<Task> posts = taskService.findAll();
        model.addAttribute("posts", posts);
        return "task";
    }

    @GetMapping("/task/add")
    public String taskAdd(Model model){
        log.info("Get : task/add");
        return "task-add";
    }

    @PostMapping("/task/add")
    public String taskPostAdd(@RequestParam String nameProject, @RequestParam String loginEmployee,
                              @RequestParam String task, Model model){
        taskService.save(nameProject, loginEmployee, task);
        log.info("Post : task/add, save new task" + task);
        return "redirect:/task";
    }

    @GetMapping("/task/{id}")
    public String taskDetails(@PathVariable(value = "id") long id, Model model){

        model.addAttribute("post", taskService.getTaskInfo(id));
        model.addAttribute("postUser", taskService.getUserInfo(id));
        log.info("Get : task/details id: " + id);
        return "task-details";
    }

    @GetMapping("/task/{id}/edit")
    public String taskEdit(@PathVariable(value = "id") long id, Model model){

        model.addAttribute("post", taskService.getTaskInfo(id));
        model.addAttribute("postUser", taskService.getUserInfo(id));
        log.info("Get : task/edit id: " + id);
        return "task-edit";
    }

    @PostMapping("/task/{id}/edit")
    public String taskPostUpdate(@PathVariable(value = "id") long id, @RequestParam String task,
                                    @RequestParam String loginEmployee,  Model model){
        taskService.taskUpdate(id, task, loginEmployee);
        log.info("Post : task/edit, save new update" + task);
        return "redirect:/task";
    }

    @PostMapping("/task/{id}/remove")
    public String taskPostDeleted(@PathVariable(value = "id") long id, Model model){
        taskService.deleteTask(id);
        log.info("Get : task deleted id: " + id);
        return "redirect:/task";
    }

}
