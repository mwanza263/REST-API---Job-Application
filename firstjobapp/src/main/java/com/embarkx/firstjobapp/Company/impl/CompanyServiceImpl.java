package com.embarkx.firstjobapp.Company.impl;

import com.embarkx.firstjobapp.Company.Company;
import com.embarkx.firstjobapp.Company.CompanyRepository;
import com.embarkx.firstjobapp.Company.CompanyService;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.impl.JobServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;
    private final JobServiceImpl jobService;

    public CompanyServiceImpl(CompanyRepository companyRepository, JobServiceImpl jobService, JobRepository jobRepository) {
        this.companyRepository = companyRepository;
        this.jobService = jobService;
        this.jobRepository =jobRepository;
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public boolean updateCompany(Company company, Long id) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company updatedCompany = existingCompany.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setJobs(company.getJobs());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {return companyRepository.findById(id).orElse(null);}
    @Override
    public boolean deleteCompany(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
