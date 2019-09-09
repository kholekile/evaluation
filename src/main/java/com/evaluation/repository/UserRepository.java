package com.evaluation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluation.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByIdNumber(String idNumber);
	
	Optional<User> findById(Integer id);
	
	List<User> findAll();
	
	@Query(value = "SELECT * FROM tuser where MATCH(first_names,last_name,id_number) " +
			 "AGAINST (:query IN NATURAL LANGUAGE MODE)", nativeQuery = true)
	List<User> search(@Param("query") String query);

}
