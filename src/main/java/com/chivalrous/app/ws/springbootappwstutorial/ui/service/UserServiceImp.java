package com.chivalrous.app.ws.springbootappwstutorial.ui.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chivalrous.app.ws.springbootappwstutorial.ui.model.User;
import com.chivalrous.app.ws.springbootappwstutorial.ui.model.UserDetails;
import com.chivalrous.app.ws.springbootappwstutorial.ui.shared.Utils;

@Service
public class UserServiceImp implements UserService {

	Utils utils;

	Map<String, User> users;

	public UserServiceImp() {
	}

	@Autowired
	public UserServiceImp(Utils utils) {
		this.utils = utils;
	}

	@Override
	public User createUser(UserDetails userDetails) {
		User returnValue = new User();

		String userId = utils.generateUserId();
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
