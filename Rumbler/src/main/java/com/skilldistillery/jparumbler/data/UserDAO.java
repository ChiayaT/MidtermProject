package com.skilldistillery.jparumbler.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.User;

public interface UserDAO {
	
	@Autowired
	User authenticateUser(User user);
	List<User> findUsersByName (String name);
	List<User> findUsersByZip (int zip);
	List<User> findUsersDiscipline (int zip);
	User findUserById(int id);
	User createUser(User user);
	User updateUser(User user);
	boolean deleteUser (int id);
	

}
