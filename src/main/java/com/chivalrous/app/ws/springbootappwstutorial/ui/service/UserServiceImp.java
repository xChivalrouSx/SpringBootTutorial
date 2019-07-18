package com.chivalrous.app.ws.springbootappwstutorial.ui.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chivalrous.app.ws.springbootappwstutorial.ui.model.User;
import com.chivalrous.app.ws.springbootappwstutorial.ui.model.UserDetails;

@Service
public class UserServiceImp implements UserService {

	Map<String, User> users;

	@Override
	public User createUser(UserDetails userDetails) {
		User returnValue = new User();

		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());

		if (users == null) {
			users = new HashMap<>();
		}
		users.put(userId, returnValue);

		return returnValue;
	}
}
