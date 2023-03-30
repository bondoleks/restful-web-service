package demo.restfulWebService.repository.commandRepository.managerRepository;

import demo.restfulWebService.model.commandModel.managerModel.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
}