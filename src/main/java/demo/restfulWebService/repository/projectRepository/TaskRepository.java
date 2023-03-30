package demo.restfulWebService.repository.projectRepository;

import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.model.projectModel.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findDistinctByIdProjectEquals(Long projectId);

}