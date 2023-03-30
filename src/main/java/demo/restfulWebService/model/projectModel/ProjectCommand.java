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
public class ProjectCommand {

    @Id
    private Long Id;

    @Column(name = "nameEmployee")
    private String nameEmployee;

    @Column(name = "role")
    private String role;
}
