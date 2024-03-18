package com.prad.JobPortal.job.model;

import com.prad.JobPortal.company.model.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String jobTitle;

    private String jobDesc;

    private String jobMinSalary;

    private String jobMaxSalary;

    private String jobLocation;

    @ManyToOne
    private Company company;

    public  Job(){

    }

    public Job(Long jobId, String jobTitle, String jobDesc, String jobMinSalary, String jobMaxSalary, String jobLocation) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDesc = jobDesc;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
        this.jobLocation = jobLocation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobMinSalary() {
        return jobMinSalary;
    }

    public void setJobMinSalary(String jobMinSalary) {
        this.jobMinSalary = jobMinSalary;
    }

    public String getJobMaxSalary() {
        return jobMaxSalary;
    }

    public void setJobMaxSalary(String jobMaxSalary) {
        this.jobMaxSalary = jobMaxSalary;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
}
