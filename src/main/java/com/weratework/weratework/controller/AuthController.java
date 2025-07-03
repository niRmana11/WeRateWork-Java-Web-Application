package com.weratework.weratework.controller;

import com.weratework.weratework.model.User;
import com.weratework.weratework.repository.RoleRepository;
import com.weratework.weratework.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");
        int roleId = Integer.parseInt(data.get("roleId"));

        if(userRepo.findByUsername(username).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(roleRepo.findById(roleId).orElse(null));
        user.setAdmin(false);

        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");


    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data, HttpSession session) {
        String username = data.get("username");
        String password = data.get("password");

        Optional<User> userOpt = userRepo.findByUsername(username);

        if(userOpt.isEmpty()){
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        User user = userOpt.get();

        if(!user.getPassword().equals(password)){
            return ResponseEntity.status(401).body("Invalid credentials");
        }


        session.setAttribute("user", user);
        Map<String, String> result = new HashMap<>();

        result.put("redirect", user.isAdmin() ? "/admin/dashboard.html" : "ratingPage.html");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        User user = (User) userObj;
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody Map<String, String> payload, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
        }

        User user = (User) userObj;
        String newUsername = payload.get("username");
        String newPassword = payload.get("password");

        if (newUsername != null && !newUsername.isBlank()) {
            user.setUsername(newUsername);
        }
        if (newPassword != null && !newPassword.isBlank()) {
            user.setPassword(newPassword); // Make sure to hash this
        }

        userRepo.save(user); // Save updated user
        return ResponseEntity.ok("Profile updated");
    }



    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

}
