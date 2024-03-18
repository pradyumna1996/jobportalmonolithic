package com.prad.JobPortal.job.service;

import com.prad.JobPortal.job.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    List<Job>  findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}
