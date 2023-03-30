package demo.restfulWebService.service;

import demo.restfulWebService.dto.ProjectDTO;
import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.repository.projectRepository.ProjectCommandRepository;
import demo.restfulWebService.repository.projectRepository.ProjectDetailsRepository;
import demo.restfulWebService.repository.projectRepository.ProjectRepository;
import demo.restfulWebService.repository.projectRepository.ProjectTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDetailsRepository projectDetailsRepository;
    private final ProjectCommandRepository projectCommandRepository;
    private final ProjectTaskRepository projectTaskRepository;

    public Project create(ProjectDTO dto){
        return projectRepository.save(Project.builder()
                .projectName(dto.getName())
                .build());
    }

    public List<Project> read(){
        return (List<Project>) projectRepository.findAll();
    }

    public Project update(Project project){
        return projectRepository.save(project);
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }
}
