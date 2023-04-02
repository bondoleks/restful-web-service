package demo.restfulWebService.repository.projectRepository;

import demo.restfulWebService.model.projectModel.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findDistinctByIdProjectEquals(Long projectId);

}