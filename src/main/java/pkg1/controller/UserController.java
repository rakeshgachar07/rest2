package pkg1.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.UserDto;
import pkg1.entity.CompanyEntity;
import pkg1.entity.UserEntity;
import pkg1.repository.CompanyRepo;
import pkg1.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo ur;
	@Autowired
	CompanyRepo cr;
	
	
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody UserDto ud) {
		int id = ud.getCompanyId();
		CompanyEntity ce = cr.findById(id).orElseThrow(()->new NullPointerException("Company not found with ID " + id));
		UserEntity ue = new UserEntity();
		ue.setFirstName(ud.getUser().getFirstName());
		ue.setLastName(ud.getUser().getLastName());
		ue.setCity(ud.getUser().getCity());
		ue.setCountryCode(ud.getUser().getCountryCode());
		ue.setEmail(ud.getUser().getEmail());
		ue.setMobileNo(ud.getUser().getMobileNo());
		ue.setPinCode(ud.getUser().getPinCode());
		ue.setCe(ce);
		return ur.save(ue);	
	}
	
	@GetMapping("/findAll")
	public List<UserEntity> getUsers(){
		return ur.findAll();
	}
	@GetMapping("/findById")
	public Optional<UserEntity> getUserById(@RequestParam int id){
		return ur.findById(id);
	}
	@GetMapping("/findById2/{id}")
	public Optional<UserEntity> getUserById2(@PathVariable int id){
		return ur.findById(id);
	}
	@GetMapping("/findByName/{name}")
	public List<UserEntity> getUserByName(@PathVariable String name){
		return ur.findByName(name);
	}
	@GetMapping("/nameStartsWith/{name}")
	public List<UserEntity> nameStartsWith(@PathVariable String name){
		List<UserEntity> list1 = ur.findAll();
		List<UserEntity> temp1 = list1.stream().filter(m -> m.getFirstName().startsWith(name)).collect(Collectors.toList());
		return temp1;
	}
	@PutMapping("/update/{id}")
	public UserEntity updateUser(@RequestBody UserEntity ue,@PathVariable int id) {
		UserEntity user = ur.findById(id).orElseThrow(()-> new NullPointerException("id doesnt exit with "  + id));
		user.setFirstName(ue.getFirstName());
		user.setLastName(ue.getLastName());
		user.setCity(ue.getCity());
		user.setCountryCode(ue.getCountryCode());
		user.setEmail(ue.getEmail());
		user.setMobileNo(ue.getMobileNo());
		user.setPinCode(ue.getPinCode());
		ur.save(user);
		return user;
	}
	
}
