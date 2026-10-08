package in.codewithakhil.journalAppNew.service;


import in.codewithakhil.journalAppNew.repository.UserRepository;
import in.codewithakhil.journalAppNew.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<?> readUser() {
        return userRepository.findAll();
    }

    public Optional<?> readById(ObjectId id) {
        return userRepository.findById(id);
    }

    public Optional<?> deleteById(ObjectId id) {
        Optional<?> dummy = userRepository.findById(id);
        userRepository.deleteById(id);
        return dummy;
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}