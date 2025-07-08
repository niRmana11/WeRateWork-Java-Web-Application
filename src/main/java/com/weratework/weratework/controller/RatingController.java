package com.weratework.weratework.controller;

import com.weratework.weratework.model.Category;
import com.weratework.weratework.model.Rating;
import com.weratework.weratework.model.Role;
import com.weratework.weratework.model.User;
import com.weratework.weratework.repository.CategoryRepository;
import com.weratework.weratework.repository.RatingRepository;
import com.weratework.weratework.repository.RoleRepository;
import com.weratework.weratework.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;
    private final CategoryRepository categoryRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

   public RatingController(RatingRepository ratingRepository, CategoryRepository categoryRepository, RoleRepository roleRepository, UserRepository userRepository) {
       this.ratingRepository = ratingRepository;
       this.categoryRepository = categoryRepository;
       this.roleRepository = roleRepository;
       this.userRepository = userRepository;
   }

   @GetMapping
    public List<Rating> getAllRatings() {
       return ratingRepository.findAll();
   }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) throw new RuntimeException("Unauthorized");

        if (rating.getCategory() == null || rating.getCategory().getId() == 0)
            throw new RuntimeException("Category is missing or invalid");

        if (rating.getRole() == null || rating.getRole().getId() == 0)
            throw new RuntimeException("Role is missing or invalid");

        Category category = categoryRepository.findById(rating.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Role role = roleRepository.findById(rating.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        rating.setCategory(category);
        rating.setRole(role);
        rating.setUser(user);

        return ratingRepository.save(rating);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateRating(@PathVariable int id, @RequestBody Rating updatedRating) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating not found");
        }

        Rating existingRating = optionalRating.get();
        existingRating.setScore(updatedRating.getScore());
        existingRating.setComment(updatedRating.getComment());

        ratingRepository.save(existingRating);
        return ResponseEntity.ok(existingRating);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable int id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating not found");
        }

        ratingRepository.deleteById(id);
        return ResponseEntity.ok().body("Rating deleted successfully");
    }




}
