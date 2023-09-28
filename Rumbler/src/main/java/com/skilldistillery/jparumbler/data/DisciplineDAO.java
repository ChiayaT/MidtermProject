package com.skilldistillery.jparumbler.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.ExperienceLevel;
import com.skilldistillery.jparumbler.entities.FightingStance;
import com.skilldistillery.jparumbler.entities.UserDiscipline;
import com.skilldistillery.jparumbler.entities.UserDisciplineId;

public interface DisciplineDAO {

	@Autowired
	UserDiscipline findDisciplineById(UserDisciplineId id);
	UserDiscipline addNewDiscipline(UserDiscipline ud, int userId, int disciplineId);
	UserDiscipline updateDiscipline(UserDiscipline userDiscipline, int userId, int disciplineId);
	boolean deleteDiscipline(int userId, int disciplineId);
	boolean enableDiscipline(int userId, int disciplineId);
	
	List<Discipline> getAllDisciplines();
	List<FightingStance> getAllFightingStances();
	List<ExperienceLevel> getAllExperienceLevels();

}
