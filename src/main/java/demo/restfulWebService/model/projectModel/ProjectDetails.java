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
@AllArgsConstructor
public class ProjectDetails {

    @Id
    private Long Id;

    @Column(name = "projectDescription")
    private String projectDescription;

    @Column(name = "projectStart")
    private String projectStart;

    @Column(name = "projectDeadline")
    private String projectDeadline;

    @Column(name = "projectBudget")
    private String projectBudget;
}
