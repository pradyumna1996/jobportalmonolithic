package com.prad.JobPortal.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prad.JobPortal.job.model.Job;
import com.prad.JobPortal.review.model.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;

    private String companyDes;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


    @OneToMany(mappedBy = "company")
    private  List<Review> reviews;

    public Company() {
    }

    public Company(Long companyId, String companyName, String companyDes, List<Job> jobs, List<Review> reviews) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDes = companyDes;
        this.jobs = jobs;
        this.reviews= reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDes() {
        return companyDes;
    }

    public void setCompanyDes(String companyDes) {
        this.companyDes = companyDes;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
