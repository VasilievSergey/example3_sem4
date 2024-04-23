package ru.gb.example3_sem4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem4.model.User;
import ru.gb.example3_sem4.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public User getOne(int id) {
        return userRepository.getOne(id);
    }
}