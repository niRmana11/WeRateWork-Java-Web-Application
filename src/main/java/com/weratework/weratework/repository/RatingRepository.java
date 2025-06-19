package com.weratework.weratework.repository;

import com.weratework.weratework.dto.CategoryRatingSummary;
import com.weratework.weratework.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT new com.weratework.weratework.dto.CategoryRatingSummary(c.name, COUNT(r), AVG(r.score)) " +
            "FROM Rating r JOIN r.category c GROUP BY c.name")
    List<CategoryRatingSummary> getCategoryRatingSummary();

}
