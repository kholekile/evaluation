package com.evaluation.dto;

import com.evaluation.model.Profile;

public class ProfileDto {
	
	public static ProfileDto toDto(Profile profile) {
		
		ProfileDto result = new ProfileDto();
		
		result.setId(profile.getId());
		result.settUSER_id(profile.gettUSER_id());
		result.settTYPES_id(profile.gettTYPES_id());
		result.setValue(profile.getValue());
		
		return result;
		
	}
	
    private Integer id;
    private Integer tUSER_id;
	private Integer tTYPES_id;
    private String value;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer gettUSER_id() {
		return tUSER_id;
	}
	public void settUSER_id(Integer tUSER_id) {
		this.tUSER_id = tUSER_id;
	}
	public Integer gettTYPES_id() {
		return tTYPES_id;
	}
	public void settTYPES_id(Integer tTYPES_id) {
		this.tTYPES_id = tTYPES_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
    
    

}
