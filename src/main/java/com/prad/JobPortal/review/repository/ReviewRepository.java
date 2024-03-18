package com.prad.JobPortal.review.repository;

import com.prad.JobPortal.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review , Long> {


    List<Review> findByCompanyCompanyId(Long companyId);

}
