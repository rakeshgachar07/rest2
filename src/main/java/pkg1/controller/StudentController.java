package pkg1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pkg1.entity.StudentEntity;
import pkg1.repository.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo sr;
	
	@PostMapping("students/add")
	public StudentEntity addStudents(@RequestBody StudentEntity se) {
		return sr.save(se);	
	}
	
	@GetMapping("students/fetch/all")
	public List<StudentEntity> getStudents() {
		return sr.findAll();
	}
	
	@GetMapping("students/fetch/{id}")
	public Optional<StudentEntity> getStudentsById(@PathVariable int id) {
		return sr.findById(id);
	}
	
	@GetMapping("students/fetch")
	public Optional<StudentEntity> getStudentsById2(@RequestParam int id) {
		return sr.findById(id);
	}
	
}
