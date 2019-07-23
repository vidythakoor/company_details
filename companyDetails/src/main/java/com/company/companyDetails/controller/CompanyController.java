package com.company.companyDetails.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.companyDetails.dao.CompanyDAO;
import com.company.companyDetails.model.Company;

@RestController
@RequestMapping("/task")

public class CompanyController {
	
	@Autowired
	CompanyDAO companyDAO;
	
	
	/* to save company */
	
	@PostMapping("/company")
	public Company createCompany(@Valid @RequestBody Company cmp) {
		 return companyDAO.save(cmp);
		
	}
	
	
	/* get all companies*/
	
	@GetMapping("/companies")
	public List <Company> getAllCompany(){
		
		return companyDAO.findall();
	}
	
	
	
	
	/*get company by id*/
	
	@GetMapping("/company/{id}")
	public Company get(@PathVariable int id) {
		Optional<Company> company = companyDAO.findById(id);
		if (company.isPresent()) {
			return company.get();
		}else {
			throw new RuntimeException("Company information not found for the id" +id);
		}
		
	}
	
	
	

	
	/*update company information*/
	@PutMapping("/companyUpdate")
		public Company update(@RequestBody Company cmp) {
			return companyDAO.save(cmp);
			
		}
	
	/* delete company information*/
	
	@DeleteMapping("/company/{id}")
	public String delete(@PathVariable int id) {
		Optional<Company> company = companyDAO.findById(id);
		if(company.isPresent()) {
			companyDAO.delete(company.get());
			return "Company information is deleted with id" +id;
		}else {
			throw new RuntimeException("Company not found for the id" +id);
		}
	}
	
	
}
