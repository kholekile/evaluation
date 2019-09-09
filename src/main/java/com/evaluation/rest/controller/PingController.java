package com.evaluation.rest.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
public class PingController {
	
	@GetMapping("/")
	public String ping() {
		
		Date today = Calendar.getInstance().getTime();
		return "PINGED AT : " + today;
	}

}
