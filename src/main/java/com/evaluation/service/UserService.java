package com.evaluation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.dto.ProfileDto;
import com.evaluation.dto.TypeDto;
import com.evaluation.dto.UserDto;
import com.evaluation.exception.DuplicateEntityException;
import com.evaluation.exception.NotFoundException;
import com.evaluation.model.Profile;
import com.evaluation.model.Type;
import com.evaluation.model.User;
import com.evaluation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private TypeService typeService;
	
	public List<UserDto> getAllUsers() {
		
		List<User> users =  this.userRepository.findAll();
		List<UserDto> userDtos = this.convertUserListToDtos(users);
		
		return userDtos;
	}
	
	public User findByIdNumber(String idNumber) {
		
		return userRepository.findByIdNumber(idNumber);
	}
	
	public UserDto addUser(UserDto userDto) {

		User user = this.findByIdNumber(userDto.getIdNumber());
		Type type = null;
		
		if (user != null) {
			
			throw new DuplicateEntityException();
			
		} else {
			
			user = new User();
			user.setFirstNames(userDto.getFirstNames());
			user.setLastName(userDto.getLastName());
			user.setIdNumber(userDto.getIdNumber());
			
			this.userRepository.save(user);
			
			if (userDto.getType() != null) {
				
				type = this.saveOrUpdateUserType(userDto.getType());
			}
			
			if (userDto.getProfile() != null && type.getId() != null && user.getId() != null) {
				
				this.saveOrUpdateUserProfile(userDto.getProfile(), type.getId(), user.getId());
				
			}
		}
		
		return this.toDto(user, true);
		
	}
	
	public Profile saveOrUpdateUserProfile(ProfileDto profileDto, Integer typeId, Integer userId) {
		
		Profile profile = null;
		
		if (profileDto.getId() != null) {

			profile = this.profileService.findById(profileDto.getId());
			
			if (profile == null) {
				throw new NotFoundException();
			}
			
		} else {
			profile = new Profile();
		}
		
		profile.settTYPES_id(typeId);
		profile.settUSER_id(userId);
		profile.setValue(profileDto.getValue());
		
		return this.profileService.saveUserProfile(profile);
	}

	public Type saveOrUpdateUserType(TypeDto typeDto) {
		
		Type type = null;
		
		if (typeDto.getId() != null) {
			
			type = this.typeService.findById(typeDto.getId());
			
			if (type == null) {
				throw new NotFoundException();
			}
			
		} else {
			
			type = new Type();
			
		}
		
		type.setType(typeDto.getType());
		type.setCellphone(typeDto.getCellphone());
		type.setDescription(typeDto.getDescription());
		type.setDeleted(typeDto.getDeleted());
		
		return this.typeService.saveUserType(type);

	}

	public UserDto updateUser(UserDto userDto) {
	
		User user = this.findById(userDto.getId());
		Type type = null;
		
		if (user == null) {
			
			throw new NotFoundException();
			
		} else {
			
			user.setIdNumber(userDto.getIdNumber());
			user.setFirstNames(userDto.getFirstNames());
			user.setLastName(userDto.getLastName());
			
			this.userRepository.save(user);
			
			if (userDto.getType() != null) {
				
				type = this.saveOrUpdateUserType(userDto.getType());
			}
			
			if (userDto.getProfile() != null && type.getId() != null && user.getId() != null) {
				
				this.saveOrUpdateUserProfile(userDto.getProfile(), type.getId(), user.getId());
				
			}
		}
		
		return this.toDto(user, true);
	}
	
	public User findById(Integer id) {
		
		User user = this.userRepository.findById(id).get();
		
		if (user == null) {
			
			throw new NotFoundException();
		}
		
		return user;
	}
	
	public void deleteUser(Integer id) {
		
		User user = this.findById(id);
		Profile profile = this.profileService.findByUserId(user.getId());
		
		if (profile != null) {
			this.typeService.deleteType(profile.gettTYPES_id());
			this.profileService.deleteProfile(profile.getId());
		}
		
		this.userRepository.delete(user);
	}
	
	public UserDto toDto(User user, boolean fullRecord) {
		
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setIdNumber(user.getIdNumber());
		userDto.setFirstNames(user.getFirstNames());
		userDto.setLastName(user.getLastName());
		
		if (fullRecord) {
			
			Profile profile = this.profileService.findByUserId(user.getId());
			userDto.setProfile((profile != null) ? ProfileDto.toDto(profile) : null);
			
			if (profile.gettTYPES_id() != null) {
		
				Type type = this.typeService.findById(profile.gettTYPES_id());
				userDto.setType((type != null) ? TypeDto.toDto(type) : null);

			}

		}
		
		return userDto;
	}

	public List<UserDto> search(String query) {
		
		List<User> users =  this.userRepository.search(query);
		List<UserDto> userDtos = this.convertUserListToDtos(users);
		
		return userDtos;
	}
	
	public List<UserDto> convertUserListToDtos(List<User> users){

		return users.stream().map(user -> this.toDto(user, true)).collect(Collectors.toList());
	}

}
