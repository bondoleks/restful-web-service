package demo.restfulWebService.repository.projectRepository;

import demo.restfulWebService.model.projectModel.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project getDbUserByName(String nameProject);

}