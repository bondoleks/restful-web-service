package demo.restfulWebService.repository.messageRepository;

import demo.restfulWebService.model.messageModel.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}