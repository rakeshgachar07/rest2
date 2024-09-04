package pkg1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{

}
