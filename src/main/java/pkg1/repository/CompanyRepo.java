package pkg1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg1.entity.CompanyEntity;

public interface CompanyRepo extends JpaRepository<CompanyEntity,Integer>{

}
