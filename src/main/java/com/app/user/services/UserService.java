package com.app.user.services;

import com.app.user.model.User;
import java.util.List;

public interface UserService {
    void create(String username,String password);
    void delete(String username);
    boolean exists(String username);
    boolean exists(String username,String password);
    User find(String username);
    User find(String username,String password);
    List<User> findAll();
    void addRole(String username,String role);
    void deleteRole(String username,String role);
}
