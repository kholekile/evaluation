package com.evaluation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluation.model.Profile;

@Repository
public interface ProfileRepository  extends CrudRepository<Profile, Integer>{
	
	@Query(value = "SELECT * FROM tprofile where tUSER_id = :userId", nativeQuery = true)
	Profile findByTypeId(@Param("userId") Integer userId);

}
