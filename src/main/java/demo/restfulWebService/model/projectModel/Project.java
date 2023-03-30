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

    @Column(name = "projectStart")
    private String start;

    @Column(name = "projectDeadline")
    private String deadline;

    @Column(name = "projectBudget")
    private String budget;

    public Project(String name, String description, String start, String deadline, String budget) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.deadline = deadline;
        this.budget = budget;
    }
}
