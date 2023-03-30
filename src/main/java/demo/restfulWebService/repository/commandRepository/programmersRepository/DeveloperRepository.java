package demo.restfulWebService.repository.commandRepository.programmersRepository;

import demo.restfulWebService.model.commandModel.programmersModel.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
}