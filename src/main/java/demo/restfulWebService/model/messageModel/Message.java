package demo.restfulWebService.model.messageModel;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idUser")
    private Long idUser;

//    @Column(name = "idUserOut")
//    private Long idUserInOut;

    @Column(name = "message")
    private String message;

//    @Column(name = "messageOut")
//    private String messageOut;

    public Message(Long idUser, String message) {
        this.idUser = idUser;
        this.message = message;
    }
}