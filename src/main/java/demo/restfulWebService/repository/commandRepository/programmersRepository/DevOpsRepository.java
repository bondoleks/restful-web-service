package demo.restfulWebService.repository.commandRepository.programmersRepository;

import demo.restfulWebService.model.commandModel.programmersModel.DevOps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevOpsRepository extends CrudRepository<DevOps, Long> {
}