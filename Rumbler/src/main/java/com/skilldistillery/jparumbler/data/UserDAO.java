package com.skilldistillery.jparumbler.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;

public interface UserDAO {
	
	@Autowired
	User authenticateUser(User user);
	List<User> findUsersByName (String name);
	List<User> findUsersByZip (String zip);
	List<User> findUsersDiscipline (String disciplineName);
	User findUserById(int id);
	User createUser(User user);
	User updateUser(User user);
	boolean deleteUser (int id);
	List<UserDiscipline> findAllDisciplinesForUser(int id);
	
	List<User> findAllUsers();
	

}
