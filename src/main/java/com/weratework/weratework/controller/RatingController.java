package com.weratework.weratework.controller;

import com.weratework.weratework.model.Category;
import com.weratework.weratework.model.Rating;
import com.weratework.weratework.model.Role;
import com.weratework.weratework.repository.CategoryRepository;
import com.weratework.weratework.repository.RatingRepository;
import com.weratework.weratework.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;
    private final CategoryRepository categoryRepository;
    private final RoleRepository roleRepository;

   public RatingController(RatingRepository ratingRepository, CategoryRepository categoryRepository, RoleRepository roleRepository) {
       this.ratingRepository = ratingRepository;
       this.categoryRepository = categoryRepository;
       this.roleRepository = roleRepository;
   }

   @GetMapping
    public List<Rating> getAllRatings() {
       return ratingRepository.findAll();
   }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
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

        return ratingRepository.save(rating);
    }






}
