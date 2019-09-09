package com.evaluation.rest.response;

public class BaseResponse {
	
	private String status = "success";
	private BaseResponseData data = new BaseResponseData();

	public void addProperty(String property, Object value) {
		this.data.addProperty(property, value);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BaseResponseData getData() {
		return data;
	}

	public void setData(BaseResponseData data) {
		this.data = data;
	}


}
