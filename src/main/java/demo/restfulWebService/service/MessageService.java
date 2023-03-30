package demo.restfulWebService.service;

        import demo.restfulWebService.model.historyModel.History;
        import demo.restfulWebService.model.messageModel.Message;
        import demo.restfulWebService.model.userModel.DbUser;
        import demo.restfulWebService.repository.historyRepository.HistoryRepository;
        import demo.restfulWebService.repository.messageRepository.MessageRepository;
        import lombok.AllArgsConstructor;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    public void save(Message message) {
        messageRepository.save(message);
    }
}
