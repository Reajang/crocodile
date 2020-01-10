package goodnews.crocodile.repository;

import goodnews.crocodile.model.Message;
import goodnews.crocodile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUserNameAndPassword(String userName, String password);

    User getUserByUserName(String userName);


}
