package com.prad.JobPortal.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prad.JobPortal.company.model.Company;
import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String reviewTitle;

    private String reviewDesc;

    private double reviewRating;

    @JsonIgnore
    @ManyToOne
    private Company company;



    public Review() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }
}
