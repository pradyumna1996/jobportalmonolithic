package com.prad.JobPortal.review.controller;

import com.prad.JobPortal.review.model.Review;
import com.prad.JobPortal.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {


    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {

        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

    }


    @PostMapping("/reviews")
    public ResponseEntity<String> addReviewOfCompany(@PathVariable Long companyId ,@RequestBody Review review){


        boolean isCompanySaved= reviewService.addReview(companyId,review);

        if(isCompanySaved) {
            return new ResponseEntity<>("Review Added Successful !!", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Review Added Unsuccessful !!", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId , @PathVariable Long reviewId ){

        return new  ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.FOUND);

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId , @PathVariable Long reviewId , @RequestBody Review review
    ){

        boolean isReviewUpdated= reviewService.updateReview(companyId,reviewId,review);

        if(isReviewUpdated)

             return new ResponseEntity<>("Review Updated",HttpStatus.OK);

        else

            return new ResponseEntity<>("Review Not Updated",HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId , @PathVariable Long reviewId){

        boolean isReviewDeleted = reviewService.deleteReview(companyId,reviewId);

        if(isReviewDeleted)

            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);

        else

            return new ResponseEntity<>("Review Not Deleted",HttpStatus.BAD_REQUEST);


    }

}
