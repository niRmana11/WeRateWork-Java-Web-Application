package com.weratework.weratework.controller;

import com.weratework.weratework.model.Rating;
import com.weratework.weratework.repository.RatingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;

   public RatingController(RatingRepository ratingRepository) {
       this.ratingRepository = ratingRepository;
   }

   @GetMapping
    public List<Rating> getAllRatings() {
       return ratingRepository.findAll();
   }

   @PostMapping
    public Rating addRating(@RequestBody Rating rating) {
       return ratingRepository.save(rating);
   }



}
