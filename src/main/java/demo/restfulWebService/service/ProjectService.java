package demo.restfulWebService.service;

import demo.restfulWebService.model.historyModel.History;
import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.model.projectModel.ProjectCommandTask;
import demo.restfulWebService.repository.historyRepository.HistoryRepository;
import demo.restfulWebService.repository.projectRepository.ProjectCommandTaskRepository;
import demo.restfulWebService.repository.projectRepository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectCommandTaskRepository projectCommandTaskRepository;
    private final HistoryRepository historyRepository;

    public List<Project> read() {
        return (List<Project>) projectRepository.findAll();
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
        historyRepository.save(new History(LocalDateTime.now() + "Project created " + project));
    }

    public void saveDefaultTaskProject(Long id){
        ProjectCommandTask projectCommandTask = new ProjectCommandTask(id,
                "Set name employee", "Set role", "Set task");
        projectCommandTaskRepository.save(projectCommandTask);
        historyRepository.save(new History(LocalDateTime.now() + "Project command task created " + projectCommandTask));
    }

    public boolean existsById(Long id) {
        return projectRepository.existsById(id);
    }

    public ArrayList<Project> getProjectInfo(Long id) {
        ArrayList<Project> result = new ArrayList<>();
        Optional<Project> post = projectRepository.findById(id);
        post.ifPresent(result::add);
        return result;
    }

    public ArrayList<ProjectCommandTask> getProjectInfoCommandTask(Long id) {
        ArrayList<ProjectCommandTask> result = new ArrayList<>();
        Optional<ProjectCommandTask> post = projectCommandTaskRepository.findById(id);
        post.ifPresent(result::add);
        return result;
    }

    public void projectUpdate(Long id, String name, String description,
                              String start, String deadline, String budget,
                              String nameEmployee, String role, String task){
        Project postEditProject = projectRepository.findById(id).orElseThrow();
        postEditProject.setName(name);
        postEditProject.setDescription(description);
        postEditProject.setStart(start);
        postEditProject.setDeadline(deadline);
        postEditProject.setBudget(budget);
        projectRepository.save(postEditProject);

        ProjectCommandTask postEditCommandTaskProject = projectCommandTaskRepository.findById(id).orElseThrow();
        postEditCommandTaskProject.setNameEmployee(nameEmployee);
        postEditCommandTaskProject.setRole(role);
        postEditCommandTaskProject.setTask(task);
        projectCommandTaskRepository.save(postEditCommandTaskProject);
        historyRepository.save(new History(LocalDateTime.now() + "Project update " + postEditProject + postEditCommandTaskProject));
    }

    public void deleteProject(Long id){
        Project deleteProject = projectRepository.findById(id).orElseThrow();
        projectRepository.delete(deleteProject);
        ProjectCommandTask deleteCommandTaskProject = projectCommandTaskRepository.findById(id).orElseThrow();
        projectCommandTaskRepository.delete(deleteCommandTaskProject);
        historyRepository.save(new History(LocalDateTime.now() + "Project deleted " + deleteProject + deleteCommandTaskProject));
    }


}
