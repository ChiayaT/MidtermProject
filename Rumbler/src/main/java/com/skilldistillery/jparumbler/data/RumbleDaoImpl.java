package com.skilldistillery.jparumbler.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Address;
import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.LocationRating;
import com.skilldistillery.jparumbler.entities.LocationRatingId;
import com.skilldistillery.jparumbler.entities.LocationType;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;
import com.skilldistillery.jparumbler.entities.User;

@Service
@Transactional
public class RumbleDaoImpl implements RumbleDAO {

	@PersistenceContext
	private EntityManager em;

	public LocationType findLocoTypeById(int id) {
		return em.find(LocationType.class, id);
	}

	public Discipline findDisciplineById(int id) {
		return em.find(Discipline.class, id);
	}

	public Location findlocationById(int id) {
		return em.find(Location.class, id);
	}

	@Override
	public List<LocationRating> getLocationRatings(int locationId) {
		List<LocationRating> locationRatings = null;
		String spql = "select lr from LocationRating lr where Location.id = :locationId";
		locationRatings = em.createQuery(spql, LocationRating.class).setParameter("disciplines", locationId)
				.getResultList();
		return locationRatings;
	}

	@Override
	public List<Rumble> getAllRumbles() {
		String spql = "SELECT R FROM Rumble R";
		return em.createQuery(spql, Rumble.class).getResultList();
	}

	public List<Location> getAllLocations() {
		String spql = "SELECT R FROM Location R";
		return em.createQuery(spql, Location.class).getResultList();
	}

	public List<LocationType> getAllLocationTypes() {
		String spql = "SELECT lt FROM LocationType lt";
		return em.createQuery(spql, LocationType.class).getResultList();
	}

	public List<Discipline> getAllDisciplines() {
		String spql = "SELECT D FROM Discipline D";
		return em.createQuery(spql, Discipline.class).getResultList();
	}

	@Override
	public Rumble findRumbleById(int Id) {
		return em.find(Rumble.class, Id);
	}

	@Override
	public Rumble createRumble(Rumble rumble) {

		rumble.setEnabled(true);
		em.persist(rumble);
		return rumble;
	}

	@Override
	public Location updateLocation(Location location) {
		Location updatedLocation = findlocationById(location.getId());
		updatedLocation.setName(location.getName());
		updatedLocation.setImage_url(location.getImage_url());
		updatedLocation.setAddress(location.getAddress());
		updatedLocation.setDescription(location.getDescription());
		updatedLocation.setAddress(location.getAddress());
		updatedLocation.setLocationType(location.getLocationType());
		Address address = em.find(Address.class, location.getAddress().getId());
		Address updatedAddress = updatedLocation.getAddress();
		System.out.println(location.getAddress());
		System.out.println(updatedAddress);
		updatedAddress.setState(address.getState());
		updatedAddress.setStreet(address.getStreet());
		updatedAddress.setStreet2(address.getStreet2());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setPhone(address.getPhone());
		updatedAddress.setZipCode(address.getZipCode());
		updatedLocation.setLocationType(location.getLocationType());
		return updatedLocation;
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
		System.out.println(rumble.getDiscipline());
		newRumble.setDiscipline(rumble.getDiscipline());

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
	public boolean enableRumble(int id) {
		Rumble enabledRumble = em.find(Rumble.class, id);
		if (enabledRumble != null) {
			enabledRumble.setEnabled(true);
			return true;
		}
		return false;
	}

	@Override
	public List<RumbleMessage> getAllRumbleMessagesPerRumble(int rumbleId) {
		String spql = "SELECT R FROM RumbleMessage R WHERE rumble.id = :rumid and enabled = true ORDER BY createDate";
		return em.createQuery(spql, RumbleMessage.class)
				.setParameter("rumid", rumbleId).getResultList();

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
		// newRM.setMessageDate(rumbleMessage.getMessageDate());
		return newRM;
	}

	@Override
	public boolean deleteRumbleMessage(int id) {
		RumbleMessage deletedRumble = em.find(RumbleMessage.class, id);
		if (deletedRumble != null) {
			deletedRumble.setEnabled(false);
			return true;
		}
		return false;
	}
	@Override
	public boolean enableRumbleMessage(int id) {
		RumbleMessage enabledRumble = em.find(RumbleMessage.class, id);
		if (enabledRumble != null) {
			enabledRumble.setEnabled(true);
			return true;
		}
		return false;
	}

	@Override
	public Location createLocation(Location location) {
		em.persist(location.getLocationType());
		em.persist(location.getAddress());
		em.persist(location);
		return location;
	}

	@Override
	public List<Rumble> getAllRumblesForSpecificUser(int id) {
		List<Rumble> allUserRumblesHostOrGuest = null;
		String jpql = "select r from Rumble r where (host_id = :id or guest_id = :id) and enabled = true";
		allUserRumblesHostOrGuest = em.createQuery(jpql, Rumble.class).setParameter("id", id).getResultList();
		return allUserRumblesHostOrGuest;
	}

	@Override
	public LocationRating createLocationRating(LocationRating locationRating) {
		em.persist(locationRating);
		return locationRating;
	}

	@Override
	public LocationRating addRatingToRatingList(int locationId, int userId, LocationRating locationRating) {
		Location location = em.find(Location.class, locationId);
		User user = em.find(User.class, userId);
		if (location != null && user != null) {
			LocationRatingId id = new LocationRatingId(userId, locationId);
			locationRating.setId(id);
			locationRating.setLocation(location);
			locationRating.setUser(user);
			em.persist(locationRating);
			return locationRating;
		}
		return null;
	}

	@Override
	public boolean deleteLocation(int id) {
		Location deletedLocation = em.find(Location.class, id);
		if (deletedLocation != null) {
			deletedLocation.setEnabled(false);
			return true;
		}
		return false;
	}
	@Override
	public boolean enableLocation(int id) {
		Location enabledLocation = em.find(Location.class, id);
		if (enabledLocation != null) {
			enabledLocation.setEnabled(true);
			return true;
		}
		return false;
	}

	@Override
	public List<LocationRating> getAllLocationRatings() {
		List<LocationRating> allLocationRatings = null;
		String jpql = "select lr from LocationRating lr";
		allLocationRatings = em.createQuery(jpql, LocationRating.class).getResultList();
		return allLocationRatings;
	}

	@Override
	public boolean deleteLocationRating(int userId, int locationId) {
		LocationRatingId id = new LocationRatingId(userId, locationId);
		LocationRating deletedLocationRating = em.find(LocationRating.class, id);
		if (deletedLocationRating != null) {
			deletedLocationRating.setEnabled(false);
			return true;
		}
		return false;
	}
	@Override
	public boolean enableLocationRating(int userId, int locationId) {
		LocationRatingId id = new LocationRatingId(userId, locationId);
		LocationRating enabledLocationRating = em.find(LocationRating.class, id);
		if (enabledLocationRating != null) {
			enabledLocationRating.setEnabled(true);
			return true;
		}
		return false;
	}

	@Override
	public LocationRating findLocationRatingById(int userId, int locationId) {
		LocationRatingId id = new LocationRatingId(userId, locationId);
		LocationRating locationRating = em.find(LocationRating.class, id);
		return locationRating;
	}

	@Override
	public List<RumbleMessage> getAllRumbleMessages() {
		List<RumbleMessage> allRumbleMessages = null;
		String jpql = "select rm from RumbleMessage rm";
		allRumbleMessages = em.createQuery(jpql, RumbleMessage.class).getResultList();
		return allRumbleMessages;
	}

}
