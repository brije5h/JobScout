package com.dev.backend.controller;


import com.dev.backend.dto.user.UserProfileDTO;
import com.dev.backend.model.User;
import com.dev.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Create User
    @PostMapping("/newUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    //Delete user by username
    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return ResponseEntity.ok("User " + username +" deleted successfully");
    }

    //Edit user
    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User updateUser){
        User user = userService.editUser(id, updateUser);
        return ResponseEntity.ok(user);
    }

    //Get user by Id
    @GetMapping("/id/{id}")
    public ResponseEntity<UserProfileDTO> getUserById(@PathVariable Long id){
        UserProfileDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    //Get user by username
    @GetMapping("/{username}")
    public ResponseEntity<UserProfileDTO> getUserDetails(@PathVariable String username){
        UserProfileDTO user = userService.getUserDetails(username);
        return ResponseEntity.ok(user);
    }

    //Get All Users
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserProfileDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }
}
