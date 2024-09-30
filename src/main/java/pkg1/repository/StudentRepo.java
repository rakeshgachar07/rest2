package pkg1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.StudentEntity;
import pkg1.pincode.PincodeEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{
	
}
