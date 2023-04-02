package demo.restfulWebService.repository.userRepository;

import demo.restfulWebService.model.userModel.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserRepository extends JpaRepository<DbUser, Long> {
    DbUser getDbUserByLogin(String login);

}