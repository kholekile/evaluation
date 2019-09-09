package com.evaluation.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.evaluation.model.Profile;
import com.evaluation.model.Type;
import com.evaluation.model.User;
import com.evaluation.repository.ProfileRepository;
import com.evaluation.repository.TypeRepository;
import com.evaluation.repository.UserRepository;

import au.com.bytecode.opencsv.CSVReader;

@Service
public class ImportService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Value("${filename}")
	private String fileName;
	
	@SuppressWarnings("resource")
	public void importData() {
		
		  try {
			  
			CSVReader reader = new CSVReader(new FileReader(fileName), '|' , '"' , 1);
			List<String[]> allRows = reader.readAll();
			
			for(String[] row : allRows){
				
				if (row != null && row.length > 8) {
					
					User user = this.populateUser(row);
					Type type = this.populateType(row);
					this.populateProfile(user, type, row);
					
				}
				
		     }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private User populateUser(String [] row) {
		
		User user = null;
		
		if (row != null) {
			
			user = new User();
			user.setFirstNames(row[2]);
			user.setLastName(row[3]);
			user.setIdNumber(row[1]);
			
			user = this.userRepository.save(user);
			
		}
		
		return user;
	}
	
	private Type populateType(String[] row) {
		
		Type type = null;
		
		if (row != null) {
			
			type = new Type();
			type.setType(row[6]);
			type.setDescription(row[7]);
			type.setDeleted((row[8].equalsIgnoreCase("f") ? 1 : 0));
			type.setCellphone(row[4]);
			
			type = this.typeRepository.save(type);
		}
		
		return type;
		
	}
	
	private void populateProfile(User user, Type type, String[] row) {
		
		if (user != null && type != null) {
			
			Profile profile = new Profile();
			profile.settUSER_id(user.getId());
			profile.settTYPES_id(type.getId());
			profile.setValue(row[5]);
			
			this.profileRepository.save(profile);
		}
		
	}
}
