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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        rating.setUser(user); // ✅ Set user from session

        return ratingRepository.save(rating);
    }







}
