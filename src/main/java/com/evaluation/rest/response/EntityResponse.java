package com.evaluation.rest.response;

public class EntityResponse<T> extends BaseResponse {
	
	public EntityResponse(String propertyName, T item) {
		super();
		super.addProperty(propertyName, item);
	}

}
