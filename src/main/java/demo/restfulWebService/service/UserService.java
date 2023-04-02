package demo.restfulWebService.service;

import demo.restfulWebService.model.historyModel.History;
import demo.restfulWebService.model.userModel.DbUser;
import demo.restfulWebService.repository.userRepository.DbUserRepository;
import demo.restfulWebService.repository.historyRepository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final DbUserRepository dbUserRepository;
    private final HistoryRepository historyRepository;

    public Iterable<DbUser> findAll() {
        return dbUserRepository.findAll();
    }

    public void save(DbUser dbUser) {
        dbUserRepository.save(dbUser);
        historyRepository.save(new History(LocalDateTime.now() + "User created " + dbUser));
    }

    public ArrayList<DbUser> getUserInfo(Long id) {
        Long checkId = id;
        if(!dbUserRepository.existsById(id)){
            checkId = 0L;
        }
        ArrayList<DbUser> result = new ArrayList<>();
        Optional<DbUser> post = dbUserRepository.findById(checkId);
        post.ifPresent(result::add);
        return result;
    }

    public void userUpdate(Long id, String name, String surname,
                           String role, String position){
        Long checkId = id;
        if(!dbUserRepository.existsById(id)){
            checkId = 0L;
        }
        DbUser postEditUser = dbUserRepository.findById(checkId).orElseThrow();
        postEditUser.setName(name);
        postEditUser.setSurname(surname);
        postEditUser.setRole(role);
        postEditUser.setPosition(position);
        dbUserRepository.save(postEditUser);
        historyRepository.save(new History(LocalDateTime.now() + "User update  " + postEditUser));
    }

    public void deleteUser(Long id){
        Long checkId = id;
        if(!dbUserRepository.existsById(id)){
            checkId = 0L;
        }
        DbUser deleteUser = dbUserRepository.findById(checkId).orElseThrow();
        dbUserRepository.delete(deleteUser);
        historyRepository.save(new History(LocalDateTime.now() + "User deleted " + deleteUser));
    }
}
