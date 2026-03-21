package com.example.FinalProject.service;

import com.example.FinalProject.entity.User;
import com.example.FinalProject.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> getAllUsersPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Page<User> findUserByName(String name, Pageable pageable) {
        return userRepository.findByUsernameContainingIgnoreCase(name, pageable);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
