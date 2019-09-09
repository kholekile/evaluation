package com.evaluation.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.rest.response.BaseResponse;
import com.evaluation.service.ImportService;

@RestController
@RequestMapping("/api/import_data")
public class ImportController {
	
	@Autowired
	private ImportService importService;
	
	@GetMapping("/")
	public BaseResponse importDataFromDsv() {
		
		this.importService.importData();
		
		return new BaseResponse();
	}

}
