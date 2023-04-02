package demo.restfulWebService.model.projectModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "projectName")
    private String name;

    @Column(name = "tasks")
    private Long tasks;

    @Column(name = "projectDescription")
    private String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
