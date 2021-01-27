package com.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>  {

	User findById(Long id);
	List<User> findByStatus(boolean status);
	@Query(	value=  "update user set status = false where id=? " , nativeQuery = true)
	User updateUser(@Param( " id " ) int id);
	
}
