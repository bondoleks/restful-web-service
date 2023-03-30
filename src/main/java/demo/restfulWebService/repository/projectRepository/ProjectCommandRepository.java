package demo.restfulWebService.repository.projectRepository;

import demo.restfulWebService.model.projectModel.ProjectCommand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCommandRepository extends CrudRepository<ProjectCommand, Long> {
}