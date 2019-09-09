package com.evaluation.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.dto.UserDto;
import com.evaluation.rest.response.BaseResponse;
import com.evaluation.rest.response.EntityListResponse;
import com.evaluation.rest.response.EntityResponse;
import com.evaluation.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public EntityListResponse<UserDto> getAllUser() {
		
		List<UserDto> users = this.userService.getAllUsers();
		
		return new EntityListResponse<UserDto>("users", users);
		
	}
	
	@PostMapping("/")
	public EntityResponse<UserDto> add(@RequestBody UserDto userDto) {
		
		UserDto user = this.userService.addUser(userDto);
		
		return new EntityResponse<>("user", user);
	}
	
	@PutMapping("/")
	public EntityResponse<UserDto> update(@RequestBody UserDto userDto) {
		
		UserDto user = this.userService.updateUser(userDto);
		
		return new EntityResponse<>("user", user);
	}
	
	@DeleteMapping("/{id}")
	public BaseResponse delete(@PathVariable Integer id) {
		
		this.userService.deleteUser(id);
		
		return new BaseResponse();	
	}
	
	@GetMapping(path = "/search")
	public EntityListResponse<UserDto>search(@RequestParam(value = "query", required = true) String query) {
		
		List<UserDto> users = this.userService.search(query);
		
		return new EntityListResponse<UserDto>("users", users);
		
	}

}
