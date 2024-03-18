package com.prad.JobPortal.job.controller;

import com.prad.JobPortal.company.model.Company;
import com.prad.JobPortal.job.model.Job;
import com.prad.JobPortal.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Job>> allJobs(){



        return new ResponseEntity<>(jobService.findAll(),HttpStatus.FOUND);

    }

    @PostMapping("/")
    public ResponseEntity<String> createJob(@RequestBody Job job){

        jobService.createJob(job);
        return new ResponseEntity<>("Added Jobs Successful",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id){

        Job job=  jobService.getJobById(id);

        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable("id") Long id){

            boolean deleted = jobService.deleteJobById(id);

            if(deleted){
                return new ResponseEntity<>("Deleted Successful",HttpStatus.OK);
            }

        return new ResponseEntity<>("Not Deleted Successful",HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById( @PathVariable("id") Long id, @RequestBody Job updatedJob ){

        boolean updated = jobService.updateJobById(id,updatedJob);


        if(updated)
            return  ResponseEntity.ok("Update Successfull");

        return  ResponseEntity.ok("Update Error ");
    }

}
