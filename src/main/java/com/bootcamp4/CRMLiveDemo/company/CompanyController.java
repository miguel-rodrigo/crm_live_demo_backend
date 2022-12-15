package com.bootcamp4.CRMLiveDemo.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public List<Company> getCompanys(){
        return companyService.getCompanies();
    }

    @PostMapping()
    public void registerNewCompany(@RequestBody Company company){
        companyService.addNewCompany(company);
    }
    @DeleteMapping(path = "{companyId}")
    public void deleteCompany(@PathVariable("companyId") Long companyId){
        companyService.deleteCompany(companyId);
    }

    @PutMapping()
    public void updateCompany(@RequestBody Company company){
        companyService.updateCompany(company);
    }
}
