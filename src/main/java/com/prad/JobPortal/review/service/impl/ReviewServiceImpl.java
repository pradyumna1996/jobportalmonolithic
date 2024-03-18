package com.prad.JobPortal.review.service.impl;

import com.prad.JobPortal.company.model.Company;
import com.prad.JobPortal.company.service.CompanyService;
import com.prad.JobPortal.review.model.Review;
import com.prad.JobPortal.review.repository.ReviewRepository;
import com.prad.JobPortal.review.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {

        List<Review> reviews=reviewRepository.findByCompanyCompanyId(companyId);

        return reviews;

    }

    @Override
    public boolean addReview(Long companyId, Review review) {

        Company company = companyService.getCompanyById(companyId);

        if(company !=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return  false;
        }

    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {

        List<Review>  reviews = reviewRepository.findByCompanyCompanyId(companyId);



        return reviews.stream().
                filter(review -> review.getReviewId().equals(reviewId)).findFirst().orElse(null);

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {

        if(companyService.getCompanyById(companyId)!=null){


            updatedReview.setCompany(companyService.getCompanyById(companyId));

            updatedReview.setReviewId(reviewId);

            reviewRepository.save(updatedReview);

            return true;
        }else{

            return false;
        }

    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId) ){

            Review review = reviewRepository.findById(reviewId).orElse(null);

            Company company= review.getCompany();

            company.getReviews().remove(review);

            review.setCompany(null);

            companyService.updateCompany(company,companyId);

            reviewRepository.deleteById(reviewId);

            return true;
        } else{
            return false;
        }



    }


}
