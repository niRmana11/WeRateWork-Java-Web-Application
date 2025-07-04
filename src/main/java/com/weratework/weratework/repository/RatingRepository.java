package com.weratework.weratework.repository;

import com.weratework.weratework.dto.CategoryRatingSummary;
import com.weratework.weratework.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT new com.weratework.weratework.dto.CategoryRatingSummary(" +
            "c.name, r.role.role, r.comment, r.score, r.createdAt) " +
            "FROM Rating r JOIN r.category c " +
            "WHERE (:start IS NULL OR r.createdAt >= :start) " +
            "AND (:end IS NULL OR r.createdAt <= :end)")
    List<CategoryRatingSummary> getCategoryRatingSummary(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    List<Rating> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Rating> findByUserId(int userId);

}
