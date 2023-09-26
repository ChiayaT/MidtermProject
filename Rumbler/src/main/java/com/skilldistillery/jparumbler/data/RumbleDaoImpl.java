package com.skilldistillery.jparumbler.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Address;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;

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
		rumble.setGuestRatingScale(1);
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
		Location location = rumble.getLocation();
		Location newLocation = newRumble.getLocation();
		newLocation.setName(location.getName());
		newLocation.setDescription(location.getDescription());
		newLocation.setImage_url(location.getImage_url());
		newLocation.setLocationType(newLocation.getLocationType());
		Address address = location.getAddress();
		Address managedAddress = newLocation.getAddress();
		managedAddress.setState(address.getState());
		managedAddress.setStreet(address.getStreet());
		managedAddress.setStreet2(address.getStreet2());
		managedAddress.setCity(address.getCity());
		managedAddress.setPhone(address.getPhone());
		managedAddress.setZipCode(address.getZipCode());
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

	@Override
	public List<RumbleMessage> getAllRumbleMessagesPerRumble(int rumbleId) {
		// TODO Auto-generated method stub
		String spql = "SELECT R FROM RubleMessage R WHERE R.rumbleMessage.id = :rumid";
		
		return em.createQuery(spql, RumbleMessage.class)
				.setParameter("rumid", findRumbleById(rumbleId)).getResultList();
	}

	@Override
	public RumbleMessage findRumbleMessageById(int id) {
		return em.find(RumbleMessage.class, id);
	}

	@Override
	public RumbleMessage createRumbleMessage(RumbleMessage rumbleMessage) {
		em.persist(rumbleMessage);
		return rumbleMessage;
	}

	@Override
	public RumbleMessage updateRumbleMessage(RumbleMessage rumbleMessage) {
		RumbleMessage newRM = findRumbleMessageById(rumbleMessage.getId());
		newRM.setContent(rumbleMessage.getContent());
		//newRM.setMessageDate(rumbleMessage.getMessageDate());
		return newRM;
	}

	@Override
	public boolean deleteRumbleMessage(int id) {
		return false;
	}

}
