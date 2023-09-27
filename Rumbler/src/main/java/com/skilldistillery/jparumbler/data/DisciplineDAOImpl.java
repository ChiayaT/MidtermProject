package com.skilldistillery.jparumbler.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.UserDiscipline;

@Service
@Transactional
public class DisciplineDAOImpl implements DisciplineDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDiscipline findDisciplineById(int id) {
		return em.find(UserDiscipline.class, id);
	}

	@Override
	public UserDiscipline updateDiscipline(UserDiscipline userDiscipline) {
		return null;
	}

	@Override
	public boolean deleteDiscipline(int id) {
		return false;
	}



}
