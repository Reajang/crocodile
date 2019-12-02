package goodnews.crocodile.services.implementations;

import goodnews.crocodile.model.User;
import goodnews.crocodile.repository.UserRepository;
import goodnews.crocodile.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceTemplate implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceTemplate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users == null) return new ArrayList<>();
        return users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
