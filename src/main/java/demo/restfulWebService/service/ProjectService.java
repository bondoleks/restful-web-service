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

    public List<Project> read() {
        return (List<Project>) projectRepository.findAll();
    }

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

    public boolean existsById(Long id) {
        return projectRepository.existsById(id);
    }

    public ArrayList<Project> getProjectInfo(Long id) {
        ArrayList<Project> result = new ArrayList<>();
        Optional<Project> post = projectRepository.findById(id);
        post.ifPresent(result::add);
        return result;
    }

    public ArrayList<Task> getProjectTaskInfo(Long id) {
        ArrayList<Task> result = new ArrayList<>();
        Optional<Task> post = taskRepository.findById(id);
        post.ifPresent(result::add);
        return result;
    }

    public void projectUpdate(Long id, String name, String description){
        Project postEditProject = projectRepository.findById(id).orElseThrow();
        postEditProject.setName(name);
        postEditProject.setDescription(description);
        projectRepository.save(postEditProject);

        historyRepository.save(new History(LocalDateTime.now() + "Project update " + postEditProject));
    }

    public void deleteProject(Long id){
        Project deleteProject = projectRepository.findById(id).orElseThrow();
        projectRepository.delete(deleteProject);
        List<Task> listDeletedTasks = taskRepository.findDistinctByIdProjectEquals(id);
        taskRepository.deleteAllInBatch(listDeletedTasks);
        historyRepository.save(new History(LocalDateTime.now() + "Project deleted " + deleteProject));
    }
}
