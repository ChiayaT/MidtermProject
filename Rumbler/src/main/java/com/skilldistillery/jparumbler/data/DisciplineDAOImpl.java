package com.skilldistillery.jparumbler.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.ExperienceLevel;
import com.skilldistillery.jparumbler.entities.FightingStance;
import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;
import com.skilldistillery.jparumbler.entities.UserDisciplineId;

@Service
@Transactional
public class DisciplineDAOImpl implements DisciplineDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDiscipline findDisciplineById(UserDisciplineId id) {
		return em.find(UserDiscipline.class, id);
	}

	@Override
	public UserDiscipline addNewDiscipline(UserDiscipline newDiscipline, int userId, int disciplineId) {
		UserDisciplineId id = new UserDisciplineId(userId, disciplineId);
		UserDiscipline ud = em.find(UserDiscipline.class, id);
		if (ud != null) {
			enableDiscipline(userId, disciplineId);
		}
		else {
			User user = em.find(User.class, userId);
			Discipline discipline = em.find(Discipline.class, disciplineId);
			newDiscipline.setId(id);
			newDiscipline.setUser(user);
			newDiscipline.setDiscipline(discipline);
			newDiscipline.setEnabled(true);
			em.persist(newDiscipline);
			return newDiscipline;
		}
		return ud;
	}

	@Override
	public UserDiscipline updateDiscipline(UserDiscipline userDiscipline, int userId, int disciplineId) {
		UserDiscipline managedUD = null;
		User user = em.find(User.class, userId);
		Discipline discipline = em.find(Discipline.class, disciplineId);
		if (user != null && discipline != null) {
			UserDisciplineId id = new UserDisciplineId(userId, disciplineId);
			managedUD = findDisciplineById(id);
			managedUD.setExperienceLevel(userDiscipline.getExperienceLevel());
			managedUD.setFightingStance(userDiscipline.getFightingStance());
			managedUD.setDescription(userDiscipline.getDescription());
			em.flush();
		}
		return managedUD;
	}

	@Override
	public boolean deleteDiscipline(int userId, int disciplineId) {
		User user = em.find(User.class, userId);
		Discipline discipline = em.find(Discipline.class, disciplineId);
		if (user != null && discipline != null) {
			UserDisciplineId id = new UserDisciplineId(userId, disciplineId);
			UserDiscipline deletedUD = findDisciplineById(id);
			if (deletedUD != null) {
				deletedUD.setEnabled(false);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean enableDiscipline(int userId, int disciplineId) {

		UserDisciplineId id = new UserDisciplineId(userId, disciplineId);
		UserDiscipline disabledUD = findDisciplineById(id);
		if (disabledUD != null) {
			disabledUD.setEnabled(true);
			return true;

		}
		return false;
	}

	@Override
	public List<Discipline> getAllDisciplines() {
		List<Discipline> allUserDisciplines = null;
		String jpql = "select d from Discipline d";
		allUserDisciplines = em.createQuery(jpql, Discipline.class).getResultList();
		return allUserDisciplines;
	}

	@Override
	public List<FightingStance> getAllFightingStances() {
		List<FightingStance> allStances = null;
		String jpql = "select f from FightingStance f";
		allStances = em.createQuery(jpql, FightingStance.class).getResultList();
		return allStances;
	}

	@Override
	public List<ExperienceLevel> getAllExperienceLevels() {
		List<ExperienceLevel> allLevels = null;
		String jpql = "select l from ExperienceLevel l";
		allLevels = em.createQuery(jpql, ExperienceLevel.class).getResultList();
		return allLevels;
	}

}
