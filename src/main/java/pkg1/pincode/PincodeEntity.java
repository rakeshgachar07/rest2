package pkg1.pincode;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pincode")
public class PincodeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull
	private int pincode;
	@Length(max = 100)
	private String location;
	@Length(max = 100)
	private String city;
	@Length(max = 100)
	private String district;
	@Length(max = 100)
	private String state;
	@Length(max = 100)
	private String country;
	
	
	public PincodeEntity() {
		super();
	}



	public PincodeEntity(long id, @NotNull int pincode, @Length(max = 100) String location,
			@Length(max = 100) String city, @Length(max = 100) String district, @Length(max = 100) String state,
			@Length(max = 100) String country) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.location = location;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
