package com.prad.JobPortal.job.repository;

import com.prad.JobPortal.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
