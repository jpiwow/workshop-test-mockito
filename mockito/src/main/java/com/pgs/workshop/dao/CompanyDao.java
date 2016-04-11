package com.pgs.workshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pgs.workshop.domain.Company;

@Repository
public class CompanyDao {
    
    public void create(Company comapny) {
        //create company
    }
    
    public Company read(Long id) {
        //read comapny
        Company company = Company.builder().id(id).companyName("CompanyName").companyRegistrationNumber("CRN10101010").build();
        return company;
    }
    
    public Company update(Company company) {
        return company;
    }
    
    public void delete(Long ig) {
        //delete company
    }
    
    public List<Company> fetchAll() {
        return new ArrayList<Company>();
    }
    
}
