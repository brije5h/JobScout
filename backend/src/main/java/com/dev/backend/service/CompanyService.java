package com.dev.backend.service;

import com.dev.backend.model.Company;
import com.dev.backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company) {
        if (companyRepository.existsByName(company.getName())) {
            throw new IllegalArgumentException("Company already exists: " + company.getName());
        }
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        return companyRepository.findById(id).map(company -> {
            company.setName(updatedCompany.getName());
            company.setIndustry(updatedCompany.getIndustry());
            company.setLocation(updatedCompany.getLocation());
            company.setWebsite(updatedCompany.getWebsite());
            company.setCareerWebsite(updatedCompany.getCareerWebsite());
            company.setDescription(updatedCompany.getDescription());
            company.setEmployeeCount(updatedCompany.getEmployeeCount());
            company.setRating(updatedCompany.getRating());
            return companyRepository.save(company);
        }).orElseThrow(() -> new IllegalArgumentException("Company not found with ID: " + id));
    }

    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new IllegalArgumentException("Company not found with ID: " + id);
        }
        companyRepository.deleteById(id);
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found with ID: " + id));
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
