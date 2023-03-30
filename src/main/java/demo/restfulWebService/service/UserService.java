package demo.restfulWebService.service;

import demo.restfulWebService.model.commandModel.DbUser;
import demo.restfulWebService.model.projectModel.Project;
import demo.restfulWebService.model.projectModel.ProjectCommandTask;
import demo.restfulWebService.repository.commandRepository.DbUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final DbUserRepository dbUserRepository;


    public List<DbUser> read() {
        return (List<DbUser>) dbUserRepository.findAll();
    }

    public Iterable<DbUser> findAll() {
        return dbUserRepository.findAll();
    }

    public void save(DbUser dbUser) {
        dbUserRepository.save(dbUser);
    }

    public boolean existsById(Long id) {
        return dbUserRepository.existsById(id);
    }

    public ArrayList<DbUser> getUserInfo(Long id) {
        ArrayList<DbUser> result = new ArrayList<>();
        Optional<DbUser> post = dbUserRepository.findById(id);
        post.ifPresent(result::add);
        return result;
    }

    public void userUpdate(Long id, String name, String surname,
                           String role, String position){
        DbUser postEditUser = dbUserRepository.findById(id).orElseThrow();
        postEditUser.setName(name);
        postEditUser.setSurname(surname);
        postEditUser.setRole(role);
        postEditUser.setPosition(position);
        dbUserRepository.save(postEditUser);

    }

    public void deleteUser(Long id){
        DbUser post = dbUserRepository.findById(id).orElseThrow();
        dbUserRepository.delete(post);
    }


}
