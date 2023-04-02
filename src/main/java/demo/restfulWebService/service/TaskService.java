package demo.restfulWebService.service;

import demo.restfulWebService.model.historyModel.History;
import demo.restfulWebService.model.projectModel.Task;
import demo.restfulWebService.model.userModel.DbUser;
import demo.restfulWebService.repository.userRepository.DbUserRepository;
import demo.restfulWebService.repository.historyRepository.HistoryRepository;
import demo.restfulWebService.repository.projectRepository.TaskRepository;
import demo.restfulWebService.repository.projectRepository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final HistoryRepository historyRepository;
    private final DbUserRepository dbUserRepository;

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public void save(String projectName, String loginEmployee, String task) {
        Long idProject = projectRepository.getDbUserByName(projectName).getId();
        Long idUser = dbUserRepository.getDbUserByLogin(loginEmployee).getId();
        Task taskObject = new Task(idProject, idUser, task);
        taskRepository.save(taskObject);
        historyRepository.save(new History(LocalDateTime.now() + "Task created " + taskObject));
    }

    public ArrayList<Task> getTaskInfo(Long id) {
        Long checkId = id;
        if(!taskRepository.existsById(id)){
            checkId = 0L;
        }
        ArrayList<Task> result = new ArrayList<>();
        Optional<Task> post = taskRepository.findById(checkId);
        post.ifPresent(result::add);
        return result;
    }

    public DbUser getUserInfo(Long id) {
        Long checkId = id;
        if(!taskRepository.existsById(id)){
            checkId = 0L;
        }
        return dbUserRepository.getById(taskRepository.getReferenceById(checkId).getIdUser());
    }

    public void taskUpdate(Long id, String task, String loginEmployee){
        Long checkId = id;
        if(!taskRepository.existsById(id)){
            checkId = 0L;
        }
        Task postTask = taskRepository.findById(checkId).orElseThrow();
        postTask.setIdUser(dbUserRepository.getDbUserByLogin(loginEmployee).getId());
        postTask.setTask(task);
        taskRepository.save(postTask);
        historyRepository.save(new History(LocalDateTime.now() + "Task update " + postTask));
    }

    public void deleteTask(Long id){
        Long checkId = id;
        if(!taskRepository.existsById(id)){
            checkId = 0L;
        }
        Task deleteCommandTaskProject = taskRepository.findById(checkId).orElseThrow();
        taskRepository.delete(deleteCommandTaskProject);
        historyRepository.save(new History(LocalDateTime.now() + "Task deleted " + deleteCommandTaskProject));
    }
}
