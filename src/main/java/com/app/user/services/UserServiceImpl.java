package com.app.user.services;

import com.app.user.exception.RoleNotFoundException;
import com.app.user.model.User;
import com.app.user.model.response.RoleDetailsResponse;
import com.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        user.setRoles("");
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
        String url = "http://roles/api/v1/roles/" + role;
        try {
            ResponseEntity<RoleDetailsResponse> response = restTemplate.getForEntity(url, RoleDetailsResponse.class);
            String roles = user.getRoles();
            roles += roles.isEmpty() ? response.getBody().getName() : ("," + response.getBody().getName());
            user.setRoles(roles);
            repository.save(user);
        } catch (Exception exception) {
            throw new RoleNotFoundException();
        }

    }

    @Override
    public void deleteRole(String username, String role) {
        User user = repository.findByUsername(username).orElseThrow(RuntimeException::new);
        String roles = Arrays.stream(user.getRoles().split(","))
                .filter(s -> !s.equals(role))
                .collect(Collectors.joining(","));
        user.setRoles(roles);
        repository.save(user);
    }
}
