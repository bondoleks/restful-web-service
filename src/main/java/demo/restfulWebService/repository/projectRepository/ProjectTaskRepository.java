package demo.restfulWebService.repository.projectRepository;

import demo.restfulWebService.model.projectModel.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}