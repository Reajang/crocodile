package goodnews.crocodile.services.interfaces;

import goodnews.crocodile.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> findUserById(Long id);

    User save(User user);

    boolean isUserExists(String userName, String password);

    void delete(Long id);
}
