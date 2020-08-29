package com.app.user.services;

import com.app.user.model.User;
import com.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void create(String username, String password) {
        Optional<User> candidate = repository.findByUsername(username);
        if (candidate.isPresent()) {
            throw new RuntimeException();
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        repository.save(user);
    }

    @Override
    public void delete(String username) {
        User user = repository.findByUsername(username).orElseThrow(RuntimeException::new);
        repository.delete(user);
    }

    @Override
    public boolean exists(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public boolean exists(String username, String password) {
        return repository.existsByUsernameAndPassword(username, password);
    }

    @Override
    public User find(String username) {
        return repository.findByUsername(username).orElseThrow(RuntimeException::new);
    }

    @Override
    public User find(String username, String password) {
        return repository.findByUsernameAndPassword(username, password).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void addRole(String username, String role) {
        User user = repository.findByUsername(username).orElseThrow(RuntimeException::new);
        // role -> 1- check if the role exists in role micro-service
        // 2 -> add the role into the corresponding user roles
        //restTemplate.getForObject("http://roles-service/api/v1/roles")

    }

    @Override
    public void deleteRole(String username, String role) {
        User user = repository.findByUsername(username).orElseThrow(RuntimeException::new);
        user.setUsername("deleted");
    }
}
