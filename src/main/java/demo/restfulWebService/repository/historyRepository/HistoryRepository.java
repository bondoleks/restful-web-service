package demo.restfulWebService.repository.historyRepository;

import demo.restfulWebService.model.historyModel.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}