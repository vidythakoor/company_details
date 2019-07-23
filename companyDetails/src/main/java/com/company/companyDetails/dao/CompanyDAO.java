package com.company.companyDetails.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.companyDetails.model.Company;
import com.company.companyDetails.repository.CompanyRepository;

@Service
public class CompanyDAO {
	
	
	@Autowired
	CompanyRepository companyRepository;

	/* save */
	
	public Company save(Company cmp) {
		
		return companyRepository.save(cmp);
	}
	
	
	
	/*  get all */
	
	
	public List <Company> findall(){
		
		return companyRepository.findAll();
	}
	
	/* get by id*/
	
	public Optional<Company> findById(int cmpid) {
		
		return companyRepository.findById(cmpid);
	}

	
	
	/*  delete by id*/
	
	public void delete(Company cmp) {
		companyRepository.delete(cmp);
		
	}
	
	
}
