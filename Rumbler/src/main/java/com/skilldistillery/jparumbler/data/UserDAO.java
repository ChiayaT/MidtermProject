package com.skilldistillery.jparumbler.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.User;

public interface UserDAO {
	
	@Autowired
	User authenticateUser(User user);
	User findUserById(int id);
	User createUser(User user);
	User updateUser(User user);
	boolean deleteUser (int id);
	

}
