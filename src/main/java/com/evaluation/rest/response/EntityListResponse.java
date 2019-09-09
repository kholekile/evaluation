package com.evaluation.rest.response;

import java.util.List;

public class EntityListResponse<T> extends BaseResponse {
	
	public EntityListResponse(String propertyName, List<T> items) {
		super();
		super.addProperty(propertyName, items);
	}

}
