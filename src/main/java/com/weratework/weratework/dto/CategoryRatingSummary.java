package com.weratework.weratework.dto;

import java.time.LocalDateTime;

public class CategoryRatingSummary {
    private String category;
    private String role;
    private String comment;
    private int score;
    private LocalDateTime createdAt;

    public CategoryRatingSummary(String category, String role, String comment, int score, LocalDateTime createdAt) {
        this.category = category;
        this.role = role;
        this.comment = comment;
        this.score = score;
        this.createdAt = createdAt;
    }

    public String getCategory() {
        return category;
    }

    public String getRole() {
        return role;
    }

    public String getComment() {
        return comment;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
