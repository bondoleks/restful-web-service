package demo.restfulWebService.controller;

import demo.restfulWebService.dto.ProjectDTO;
import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectDTO dto){
        return new ResponseEntity<>(projectService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Project>> read(){
        return new ResponseEntity<>(projectService.read(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Project> update(@RequestBody Project project){
        return new ResponseEntity<>(projectService.update(project), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        projectService.delete(id);
        return HttpStatus.OK;
    }



    @GetMapping("/project")
    public String project(Model model){
        log.info("Get : project");
//        Iterable<DbUser> posts = postService.findAll();
//        model.addAttribute("posts", posts);
        return "project";
    }

}
