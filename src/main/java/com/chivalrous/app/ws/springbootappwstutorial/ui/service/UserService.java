package com.chivalrous.app.ws.springbootappwstutorial.ui.service;

import com.chivalrous.app.ws.springbootappwstutorial.ui.model.User;
import com.chivalrous.app.ws.springbootappwstutorial.ui.model.UserDetails;

public interface UserService {

	User createUser(UserDetails userDetails);
}
