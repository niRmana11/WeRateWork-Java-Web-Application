package com.weratework.weratework.controller;

import com.weratework.weratework.model.Rating;
import com.weratework.weratework.model.User;
import com.weratework.weratework.repository.RatingRepository;
import com.weratework.weratework.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;

    public ProfileController(RatingRepository ratingRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/ratings")
    public ResponseEntity<?> getUserRatings(HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
        }

        User user = (User) userObj;
        Optional<Rating> ratings = ratingRepository.findById(user.getId());

        return ResponseEntity.ok(ratings);
    }
    
}
