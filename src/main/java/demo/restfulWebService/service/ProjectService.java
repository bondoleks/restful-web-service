package demo.restfulWebService.service;

import demo.restfulWebService.model.historyModel.History;
import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.model.projectModel.Task;
import demo.restfulWebService.repository.historyRepository.HistoryRepository;
import demo.restfulWebService.repository.projectRepository.TaskRepository;
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
    private final TaskRepository taskRepository;
    private final HistoryRepository historyRepository;

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }
    public List<Task> findAllTask(Long id) {
        return taskRepository.findDistinctByIdProjectEquals(id);
    }

    public void save(Project project) {
        projectRepository.save(project);
        historyRepository.save(new History(LocalDateTime.now() + "Project created " + project));
    }

    public ArrayList<Project> getProjectInfo(Long id) {
        Long checkId = id;
        if(!projectRepository.existsById(id)){
            checkId = 0L;
        }
        ArrayList<Project> result = new ArrayList<>();
        Optional<Project> post = projectRepository.findById(checkId);
        post.ifPresent(result::add);
        return result;
    }

    public void projectUpdate(Long id, String name, String description){
        Long checkId = id;
        if(!projectRepository.existsById(id)){
            checkId = 0L;
        }
        Project postEditProject = projectRepository.findById(checkId).orElseThrow();
        postEditProject.setName(name);
        postEditProject.setDescription(description);
        projectRepository.save(postEditProject);
        historyRepository.save(new History(LocalDateTime.now() + "Project update " + postEditProject));
    }

    public void deleteProject(Long id){
        Long checkId = id;
        if(!projectRepository.existsById(id)){
            checkId = 0L;
        }
        Project deleteProject = projectRepository.findById(checkId).orElseThrow();
        projectRepository.delete(deleteProject);
        List<Task> listDeletedTasks = taskRepository.findDistinctByIdProjectEquals(id);
        taskRepository.deleteAllInBatch(listDeletedTasks);
        historyRepository.save(new History(LocalDateTime.now() + "Project deleted " + deleteProject));
    }
}
