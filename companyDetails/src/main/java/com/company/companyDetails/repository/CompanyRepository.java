package com.company.companyDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.companyDetails.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

	
}
