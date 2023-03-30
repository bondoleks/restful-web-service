package demo.restfulWebService.repository.projectRepository;

import demo.restfulWebService.model.projectModel.ProjectCommandTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCommandTaskRepository extends CrudRepository<ProjectCommandTask, Long> {
}