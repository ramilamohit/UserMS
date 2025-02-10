package com.tekarch.TafUserService.Controller;

import com.tekarch.TafUserService.DTO.UserDTO;
import com.tekarch.TafUserService.Service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-management")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserServiceImpl userserviceImpl;
    private static final Logger logger = LogManager.getLogger(UserController.class);

    public UserController(UserServiceImpl userserviceImpl) {
        this.userserviceImpl = userserviceImpl;
    }


    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        logger.info("Requesting to create a new user {}",userDTO.getUsername());
        return ResponseEntity.ok(userserviceImpl.registerUser(userDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        logger.info("Update the user details for user id "  + id);
        return ResponseEntity.ok(userserviceImpl.updateUser(id, userDTO));
    }
    @GetMapping("/get/username/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        UserDTO user = userserviceImpl.getUserByUsername(username);
        logger.info("Getting the user details for user " + username);
        return ResponseEntity.ok(user);
    }

    // Get user by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = userserviceImpl.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Get all users
    @GetMapping("/get-all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userserviceImpl.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
