package demo.restfulWebService.repository.historyRepository;

import demo.restfulWebService.model.historyModel.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
}