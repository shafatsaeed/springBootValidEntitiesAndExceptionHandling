package com.tech.register.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech.register.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public User findByUserId(String userId);
	public boolean existsByUserId(String userId);
}
