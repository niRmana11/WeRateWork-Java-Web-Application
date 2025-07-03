package com.weratework.weratework.controller;

import com.weratework.weratework.model.User;
import com.weratework.weratework.model.Rating;
import com.weratework.weratework.repository.RatingRepository;
import com.weratework.weratework.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
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
    public ResponseEntity<List<Rating>> getUserRatings(Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // principal.getName() returns username of logged-in user
        Optional<User> user = userRepository.findByUsername(principal.getName());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<Rating> ratings = ratingRepository.findById(user.get());
        return ResponseEntity.ok(ratings);
    }
    
}
