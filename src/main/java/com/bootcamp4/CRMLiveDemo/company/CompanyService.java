package com.bootcamp4.CRMLiveDemo.company;

import com.bootcamp4.CRMLiveDemo.company.Company;
import com.bootcamp4.CRMLiveDemo.company.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }


    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public void addNewCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        boolean exists = companyRepository.existsById(companyId);
        if(!exists){
            throw new IllegalStateException("Company with given Id: "+companyId+" does not exists on the database");
        }
        companyRepository.deleteById(companyId);
    }

    @Transactional
    public void updateCompany(Company company) {
        boolean exists = companyRepository.existsById(company.getId());
        if(!exists){
            throw new IllegalStateException("Company with given Id: "+company.getId()+" does not exists on the database");
        }
        Optional<Company> companyOptional = companyRepository.findById(company.getId());
        companyOptional.get().setName(company.getName());
    }
}
