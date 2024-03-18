package com.prad.JobPortal.company.controller;

import com.prad.JobPortal.company.model.Company;
import com.prad.JobPortal.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("")
    public ResponseEntity<List<Company>> getAllCompanies(){

        return  new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanies(@PathVariable long id , @RequestBody Company company){

        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Company Updated Successful", HttpStatus.CREATED);

    }

    @PostMapping
    public ResponseEntity<String> addCompany( @RequestBody Company company){

        companyService.createCompany(company);

        return new ResponseEntity<>("New Company Added !!" ,HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){

        boolean isDeleted= companyService.deleteCompanyById(id);

        if(isDeleted){
            return new ResponseEntity<>("Company Deleted !!!" , HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Company Not Found!!!" , HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){

        Company company = companyService.getCompanyById(id);
        if(company!=null){
              return new ResponseEntity<>(company,HttpStatus.FOUND);
        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
