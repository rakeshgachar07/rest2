package pkg1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg1.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{
	@Query(value = "select * from user where first_name like:name",nativeQuery = true)
	public List<UserEntity> findByName(@Param("name") String name);
}
