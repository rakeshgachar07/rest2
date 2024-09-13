package pkg1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkg1.entity.CompanyEntity;
import pkg1.repository.CompanyRepo;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyRepo cr;
	@PostMapping("/create")
	public CompanyEntity createCompany(@RequestBody CompanyEntity ce) {
		return cr.save(ce);
	}
	
	@GetMapping("/findAll")
	public List<CompanyEntity> getAllCompany() {
		return cr.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public CompanyEntity getCompanyById(@PathVariable int id) {
		return cr.findById(id).orElseThrow(()-> new NullPointerException("comapany not found with " + id));
	}
}
