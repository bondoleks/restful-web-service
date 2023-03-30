package demo.restfulWebService.repository.commandRepository.programmersRepository;

import demo.restfulWebService.model.commandModel.programmersModel.QA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QARepository extends CrudRepository<QA, Long> {
}