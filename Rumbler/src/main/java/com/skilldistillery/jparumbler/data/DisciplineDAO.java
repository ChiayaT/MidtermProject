package com.skilldistillery.jparumbler.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.Address;
import com.skilldistillery.jparumbler.entities.UserDiscipline;

public interface DisciplineDAO {

	@Autowired
	UserDiscipline findDisciplineById(int id);
	UserDiscipline updateDiscipline(UserDiscipline userDiscipline);
	boolean deleteDiscipline(int id);

}
