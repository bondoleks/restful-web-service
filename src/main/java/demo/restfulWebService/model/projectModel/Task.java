package demo.restfulWebService.model.projectModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "idProject")
    private Long idProject;

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "task")
    private String task;

    public Task(Long idProject, Long idUser, String task) {
        this.idProject = idProject;
        this.idUser = idUser;
        this.task = task;
    }
}
