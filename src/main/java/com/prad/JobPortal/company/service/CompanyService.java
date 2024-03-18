package com.prad.JobPortal.company.service;

import com.prad.JobPortal.company.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    public Company getCompanyById(Long id);

}
