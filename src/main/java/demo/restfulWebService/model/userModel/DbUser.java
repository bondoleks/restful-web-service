package demo.restfulWebService.model.userModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "db_user")
public class DbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "position")
    private String position;

    @Column(name = "role")
    private String role;

    public DbUser(String login, String password, String name, String surname, String role, String position) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.position = position;
    }

    @Override
    public String toString() {
        return "DbUser{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}