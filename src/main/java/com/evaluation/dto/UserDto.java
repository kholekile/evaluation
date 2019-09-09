package com.evaluation.dto;

public class UserDto {
	
    private Integer id;
    private String firstNames;
    private String lastName;
    private String idNumber;
    private TypeDto type;
    private ProfileDto profile;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstNames() {
		return firstNames;
	}
	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public TypeDto getType() {
		return type;
	}
	public void setType(TypeDto type) {
		this.type = type;
	}
	public ProfileDto getProfile() {
		return profile;
	}
	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}
}
