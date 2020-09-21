package com.app.user.controller;

import com.app.user.model.User;
import com.app.user.model.request.AddRoleRequest;
import com.app.user.model.request.UserCreationRequest;
import com.app.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserCreationRequest request) {
        userService.create(request.getUsername(), request.getPassword());
        URI uri = UriComponentsBuilder.fromPath("/api/v1/users/{name}").build(request.getUsername());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/")
    public ResponseEntity list() {
        List<User> users = userService.findAll().stream().map(user -> {
            user.setPassword("");
            return user;
        }).collect(Collectors.toList());
        return ResponseEntity.ok().body(users);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        User user = userService.find(username);
        user.setPassword("");
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteUser(@PathVariable("username") String username) {

        userService.delete(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{username}/roles/")
    public ResponseEntity AddRole(@PathVariable("username") String username, @RequestBody AddRoleRequest role) {
        userService.addRole(username, role.getName());
        URI uri = (URI) UriComponentsBuilder.fromPath("/api/v1/users/{name}").build(username);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{username}/roles/{role}")
    public ResponseEntity AddRole(@PathVariable("username") String username, @PathVariable("role") String role) {
        userService.deleteRole(username, role);
        return ResponseEntity.noContent().build();
    }

}
