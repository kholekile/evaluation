package com.evaluation.dto;

import com.evaluation.model.Type;

public class TypeDto {
	
	public static TypeDto toDto(Type type) {
		
		TypeDto result = new TypeDto();
		
		result.setId(type.getId());
		result.setType(type.getType());
		result.setDescription(type.getDescription());
		result.setDeleted(type.getDeleted());
		result.setCellphone(type.getCellphone());
		
		return result;
		
	}
	
	private Integer id;
	private String type;
	private String description;
	private Integer deleted;
	private String cellphone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}
