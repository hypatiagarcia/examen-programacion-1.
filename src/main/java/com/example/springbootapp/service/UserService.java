package com.example.springbootapp.service;

import com.example.springbootapp.model.User;
import com.example.springbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        System.out.println("DEBUG: UserService.findAll() llamado");
        List<User> users = userRepository.findAll();
        System.out.println("DEBUG: Usuarios encontrados en base de datos: " + users.size());
        return users;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}

