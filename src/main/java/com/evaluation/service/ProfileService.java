package com.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.exception.NotFoundException;
import com.evaluation.model.Profile;
import com.evaluation.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	public Profile findByUserId(Integer id) {
		
		return this.profileRepository.findByTypeId(id);
	}
	
	public void deleteProfile(Integer id) {
		
		Profile profile = this.findById(id);
		
		if (profile == null) {
			throw new NotFoundException();
		}
		
		this.profileRepository.delete(profile);
		
	}
	
	public Profile findById(Integer id) {
		
		return this.profileRepository.findById(id).get();
		
	}

	public Profile saveUserProfile(Profile profile) {
		
		return this.profileRepository.save(profile);
	}

}
