package com.prad.JobPortal.company.service.impl;

import com.prad.JobPortal.company.model.Company;
import com.prad.JobPortal.company.repository.CompanyRepository;
import com.prad.JobPortal.company.service.CompanyService;
import com.prad.JobPortal.job.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;

    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {

        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();

            companyToUpdate.setCompanyName(company.getCompanyName());

            companyToUpdate.setCompanyDes(company.getCompanyDes());

            companyRepository.save(companyToUpdate);
            return true;

        }else{
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {

        companyRepository.save(company);

    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);

    }


}


