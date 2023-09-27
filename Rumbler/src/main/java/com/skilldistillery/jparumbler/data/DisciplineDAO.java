package com.skilldistillery.jparumbler.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.ExperienceLevel;
import com.skilldistillery.jparumbler.entities.FightingStance;
import com.skilldistillery.jparumbler.entities.UserDiscipline;
import com.skilldistillery.jparumbler.entities.UserDisciplineId;

public interface DisciplineDAO {

	@Autowired
	UserDiscipline findDisciplineById(UserDisciplineId id);
	UserDiscipline updateDiscipline(UserDiscipline userDiscipline);
	boolean deleteDiscipline(UserDisciplineId id);
	
	List<FightingStance> getAllFightingStances();
	List<ExperienceLevel> getAllExperienceLevels();

}
