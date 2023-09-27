package com.skilldistillery.jparumbler.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.ExperienceLevel;
import com.skilldistillery.jparumbler.entities.FightingStance;
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
	public UserDiscipline updateDiscipline(UserDiscipline userDiscipline) {
		UserDiscipline managedUD = findDisciplineById(userDiscipline.getId());
		// i think this method is going to break but trying to avoid the get/set for all
		// the joined relationships in this table by seeing if we can do it this way
		// first
		managedUD.setUser(userDiscipline.getUser());
		managedUD.setDiscipline(userDiscipline.getDiscipline());
		managedUD.setExperienceLevel(userDiscipline.getExperienceLevel());
		managedUD.setFightingStance(userDiscipline.getFightingStance());
		managedUD.setDescription(userDiscipline.getDescription());
		managedUD.setLastUpdate(LocalDateTime.now());
		em.flush();
		return managedUD;
	}

	@Override
	public boolean deleteDiscipline(UserDisciplineId id) {
		return false;
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
