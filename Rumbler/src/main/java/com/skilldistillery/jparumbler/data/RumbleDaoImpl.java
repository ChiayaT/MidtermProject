package com.skilldistillery.jparumbler.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.User;

@Service
@Transactional
public class RumbleDaoImpl implements RumbleDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Rumble> getAllRumbles() {
		String spql = "SELECT R FROM Ruble R";
		return em.createQuery(spql, Rumble.class).getResultList();
	}

	@Override
	public Rumble findRumbleById(int Id) {
		return em.find(Rumble.class, Id);
	}

	@Override
	public Rumble createRumble(Rumble rumble) {
		em.persist(rumble);
		return rumble;
	}

	@Override
	public Rumble updateRumble(Rumble rumble) {
		Rumble newRumble = findRumbleById(rumble.getId());
		newRumble.setTitle(rumble.getTitle());
		newRumble.setDescription(rumble.getDescription());
		newRumble.setLocation(rumble.getLocation());
		newRumble.setHostRatingComment(rumble.getHostRatingComment());
		newRumble.setHostRatingScale(rumble.getHostRatingScale());
		newRumble.setGuestRatingComment(rumble.getGuestRatingComment());
		newRumble.setGuestRatingScale(rumble.getGuestRatingScale());
		newRumble.setStartTime(rumble.getStartTime());
		newRumble.setRumbleDate(rumble.getRumbleDate());
		newRumble.setEndTime(rumble.getEndTime());
		newRumble.setOpenToPublic(rumble.getOpenToPublic());
		newRumble.setDiscipline(rumble.getDiscipline());
		newRumble.setRumbleMessages(rumble.getRumbleMessages());
		return newRumble;
	}

	@Override
	public boolean deleteRumble(int id) {
		Rumble deletedRumble = em.find(Rumble.class, id);
		if (deletedRumble != null) {
			deletedRumble.setEnabled(false);
			return true;
		}
		return false;
	}

}
