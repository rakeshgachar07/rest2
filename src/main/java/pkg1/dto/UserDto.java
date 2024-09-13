package pkg1.dto;

import pkg1.entity.UserEntity;

public class UserDto {
	private int companyId;
	private UserEntity user;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
}
