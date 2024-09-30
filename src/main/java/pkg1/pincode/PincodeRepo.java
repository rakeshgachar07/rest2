package pkg1.pincode;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PincodeRepo extends  JpaRepository<PincodeEntity,Long>{
	@Query(value="SELECT * FROM pincode where pincode =:pin",nativeQuery =true)
	public List<PincodeEntity> findByPincode(@Param(value = "pin") int pincode);
}
