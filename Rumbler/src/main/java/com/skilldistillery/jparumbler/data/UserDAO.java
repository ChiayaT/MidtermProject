package com.skilldistillery.jparumbler.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.User;

public interface UserDAO {
	
	@Autowired
	User authenticateUser(User user);

}
