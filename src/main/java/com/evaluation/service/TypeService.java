package com.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.exception.NotFoundException;
import com.evaluation.model.Type;
import com.evaluation.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	private TypeRepository typeRepository;

	public Type findById(Integer id) {
		
		return this.typeRepository.findById(id).get();
	}

	public void deleteType(Integer id) {
		
		Type type = this.findById(id);
		
		if (type == null) {
			throw new NotFoundException();
		}
		
		this.typeRepository.delete(type);
	}

	public Type saveUserType(Type type) {
		
		return this.typeRepository.save(type);
		
	}


}
