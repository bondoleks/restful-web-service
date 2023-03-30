package demo.restfulWebService.model.projectModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
public class ProjectCommandTask {

    @Id
    private Long Id;

    @Column(name = "nameEmployee")
    private String nameEmployee;

    @Column(name = "role")
    private String role;

    @Column(name = "task")
    private String task;

    public ProjectCommandTask(Long id, String nameEmployee, String role, String task) {
        Id = id;
        this.nameEmployee = nameEmployee;
        this.role = role;
        this.task = task;
    }
}
