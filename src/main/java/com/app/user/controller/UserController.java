package com.app.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
//    @Autowired
//    UserService userService;
//    @Autowired
//    RoleService roleService;
//    @Autowired
//    TokenService tokenService;
//
//
//    @PostMapping("users")
//    public void create(User user) {
//     userService.save(user);
//    }
//
//
//    @GetMapping("users")
//    public ResponseEntity<List<User>> users() {
//        List<User> users = userService.findAll();
//        return ResponseEntity.ok().body(users);
//    }
//
//    @GetMapping("users/{id}")
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//
//        User user = userService.findAll().stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new ResourceNotFoundException("Not found"));
//        return ResponseEntity.ok().body(user);
//    }
//
//    //@CrossOrigin(origins = "http://localhost:3000")
//    @DeleteMapping("users/{id}")
//    public ResponseEntity deleteUser(@PathVariable("id") long id) {
//
//        userService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("users/token")
//    public ResponseEntity AddToken(@PathVariable("id")long id, Token token){
//        User user = userService.findAll().stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new ResourceNotFoundException("Not found"));
//        userService.saveToken(user, token);
//        return ResponseEntity.ok().body(user);
//    }
//
//    @PostMapping("users/role")
//    public ResponseEntity AddRole(@PathVariable("id")long id, Role role){
//        User user = userService.findAll().stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new ResourceNotFoundException("Not found"));
//        userService.saveRole(user, role);
//        return ResponseEntity.ok().body(user);
//    }

}
