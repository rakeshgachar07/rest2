package pkg1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length= 255)
	private String firstName;
	@Column(length= 255)
	private String lastName;
	@Column(length= 3)
	private String countryCode;
	@Column(unique = true)
	private long mobileNo;
	@Column(length= 50,unique = true)
	private String email;
	private int pinCode;
	@Column(length= 70)
	private String city;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="companyId")
	private CompanyEntity ce;
	
	
	public UserEntity() {
		super();
	}

	public UserEntity(int id, String firstName, String lastName, String countryCode, long mobileNo, String email,
			int pinCode, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryCode = countryCode;
		this.mobileNo = mobileNo;
		this.email = email;
		this.pinCode = pinCode;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CompanyEntity getCe() {
		return ce;
	}

	public void setCe(CompanyEntity ce) {
		this.ce = ce;
	}
	
	
	
	
}
