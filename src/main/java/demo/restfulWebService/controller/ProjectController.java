package demo.restfulWebService.controller;

import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.model.projectModel.Task;
import demo.restfulWebService.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@Log4j2
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/")
    public String home(Model model){
        log.info("Get : project");
        Iterable<Project> posts = projectService.findAll();
        model.addAttribute("posts", posts);
        return "project";
    }

    @GetMapping("/project")
    public String project(Model model){
        log.info("Get : project");
        Iterable<Project> posts = projectService.findAll();
        model.addAttribute("posts", posts);
        return "project";
    }

    @GetMapping("/project/add")
    public String projectAdd(Model model){
        log.info("Get : project/add");
        return "project-add";
    }

    @PostMapping("/project/add")
    public String projectPostAdd(@RequestParam String name, @RequestParam String description,
                              @RequestParam String start, @RequestParam String deadline,
                              @RequestParam String budget, Model model){
        Project newProject = new Project(name, description, start, deadline, budget);
        projectService.save(newProject);
        log.info("Post : project/add, save new project" + name);
        return "redirect:/project";
    }

    @GetMapping("/project/{id}")
    public String projectDetails(@PathVariable(value = "id") long id, Model model){
        if(!projectService.existsById(id)){
            return "redirect:/project";
        }
        model.addAttribute("post", projectService.getProjectInfo(id));
        model.addAttribute("postsTasks", projectService.findAllTask(id));
        log.info("Get : project/details id: " + id);
        return "project-details";
    }

    @GetMapping("/project/{id}/edit")
    public String projectEdit(@PathVariable(value = "id") long id, Model model){
        if(!projectService.existsById(id)){
            return "redirect:/project";
        }
        model.addAttribute("post", projectService.getProjectInfo(id));
        log.info("Get : project/edit id: " + id);
        return "project-edit";
    }

    @PostMapping("/project/{id}/edit")
    public String projectPostUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String description,
                                 @RequestParam String start, @RequestParam String deadline, @RequestParam String budget,  Model model){
        projectService.projectUpdate(id, name, description, start, deadline, budget);
        log.info("Post : project/edit, save new update" + name);
        return "redirect:/project";
    }

    @PostMapping("/project/{id}/remove")
    public String projectPostDeleted(@PathVariable(value = "id") long id, Model model){
        projectService.deleteProject(id);
        log.info("Get : project deleted id: " + id);
        return "redirect:/project";
    }



    //    @PostMapping
//    public ResponseEntity<Project> create(@RequestBody ProjectDTO dto){
//        return new ResponseEntity<>(projectService.create(dto), HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Project>> read(){
//        return new ResponseEntity<>(projectService.read(), HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<Project> update(@RequestBody Project project){
//        return new ResponseEntity<>(projectService.update(project), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable Long id){
//        projectService.delete(id);
//        return HttpStatus.OK;
//    }

}
