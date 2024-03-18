package com.prad.JobPortal.review.service;

import com.prad.JobPortal.company.model.Company;
import com.prad.JobPortal.review.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId , Review review);

    Review getReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId,Long reviewId, Review review);

    boolean deleteReview(Long companyId,Long reviewId );

}
