package com.weratework.weratework.controller;

import com.weratework.weratework.dto.CategoryRatingSummary;
import com.weratework.weratework.repository.RatingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final RatingRepository ratingRepository;

    public AdminController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/ratings-summary")
    public List<CategoryRatingSummary> getRatingsSummary() {
        return ratingRepository.getCategoryRatingSummary();
    }


}
