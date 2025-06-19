package com.weratework.weratework.dto;

public class CategoryRatingSummary {

    private String category;
    private long totalRating;
    private double averageRating;

    public CategoryRatingSummary(String category, long totalRating, double averageRating) {
        this.category = category;
        this.totalRating = totalRating;
        this.averageRating = averageRating;
    }

    public String getCategory() {
        return category;
    }

    public long getTotalRating() {
        return totalRating;
    }

    public double getAverageRating() {
        return averageRating;
    }
}
