package demo.restfulWebService.model.projectModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

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
