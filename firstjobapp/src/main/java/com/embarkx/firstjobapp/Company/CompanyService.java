package com.embarkx.firstjobapp.Company;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompanyService {
    void addCompany(Company company);
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    boolean deleteCompany(Long id);
    Company getCompanyById(Long id);
}
