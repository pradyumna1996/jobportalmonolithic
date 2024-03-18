package com.prad.JobPortal.company.repository;

import com.prad.JobPortal.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
