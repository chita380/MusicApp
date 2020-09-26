package com.MusicApp.Registration.service;

import com.MusicApp.Registration.model.User;

public interface RegistrationService {

	User saveUser(User user);

	User fetchUserByEmailId(String email);

	User fetchUserByEmailIdAndPassword(String email, String password);
}
