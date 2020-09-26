package com.MusicApp.Registration.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MusicApp.Registration.model.User;

public interface Registrationdao extends MongoRepository<User, Integer> {

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String emailId, String password);

}
