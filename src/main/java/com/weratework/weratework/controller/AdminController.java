package com.weratework.weratework.controller;

import com.weratework.weratework.dto.CategoryRatingSummary;
import com.weratework.weratework.model.Rating;
import com.weratework.weratework.repository.RatingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final RatingRepository ratingRepository;

    public AdminController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/ratings-summary")
    public List<CategoryRatingSummary> getCategoryRatingSummary(
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end
    ) {
        List<Rating> ratings;

        if (start != null && end != null) {
            LocalDateTime startDate = LocalDateTime.parse(start);
            LocalDateTime endDate = LocalDateTime.parse(end);
            ratings = ratingRepository.findByCreatedAtBetween(startDate, endDate);
        } else {
            ratings = ratingRepository.findAll();
        }

        List<CategoryRatingSummary> summaryList = new ArrayList<>();
        for (Rating r : ratings) {
            summaryList.add(new CategoryRatingSummary(
                    r.getCategory().getName(),
                    r.getRole().getRole(),
                    r.getComment(),
                    r.getScore(),
                    r.getCreatedAt()
            ));
        }
        return summaryList;
    }

}
