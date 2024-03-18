package com.prad.JobPortal.job.service.impl;

import com.prad.JobPortal.job.model.Job;
import com.prad.JobPortal.job.repository.JobRepository;
import com.prad.JobPortal.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs= new ArrayList<>();

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository= jobRepository;
    }

    //private Long nextId=1L;


    @Override
    public List<Job> findAll() {

        //return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

//        job.setJobId(nextId++);
//        jobs.add(job);

        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

//        for(Job job: jobs){
//            if(job.getJobId().equals(id)){
//                    return job;
//            }
//
//
//        }
//        return null;

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {

//        Iterator<Job> iterator = jobs.iterator();
//
//        while(iterator.hasNext()){
//            Job job = iterator.next();
//            if(job.getJobId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//
//        return false;

        try{

            jobRepository.deleteById(id);
            return true;

        }catch(Exception e){

            return  false;
        }
        }


    @Override
    public boolean updateJobById(Long id, Job updatedJob) {

//            for(Job job: jobs){
//
//                if(job.getJobId().equals(id)){
//
//                    job.setJobTitle(updatedJob.getJobTitle());
//                    job.setJobDesc(updatedJob.getJobDesc());
//                    job.setJobMinSalary(updatedJob.getJobMinSalary());
//                    job.setJobMaxSalary(updatedJob.getJobMaxSalary());
//                    job.setJobLocation(updatedJob.getJobLocation());
//                    return true;
//
//                }
//
//            }
//
//        return false;


        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();

            job.setJobTitle(updatedJob.getJobTitle());
            job.setJobDesc(updatedJob.getJobDesc());
            job.setJobMinSalary(updatedJob.getJobMinSalary());
            job.setJobMaxSalary(updatedJob.getJobMaxSalary());
            job.setJobLocation(updatedJob.getJobLocation());
            jobRepository.save(job);
            return true;


        }
        return false;
    }


}
