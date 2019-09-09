package com.evaluation.rest.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class BaseResponseData {

	private Map<String, Object> dynaProps = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> any() {
		return dynaProps;
	}
	
	public void addProperty(String property, Object value) {
		this.dynaProps.put(property, value);
	}
}
