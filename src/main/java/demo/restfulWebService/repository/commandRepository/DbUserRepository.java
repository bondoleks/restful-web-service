package demo.restfulWebService.repository.commandRepository;

import demo.restfulWebService.model.userModel.DbUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserRepository extends CrudRepository<DbUser, Long> {
}