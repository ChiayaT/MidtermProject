package com.skilldistillery.jparumbler.data;

import java.util.List;

import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.LocationRating;
import com.skilldistillery.jparumbler.entities.LocationType;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;

public interface RumbleDAO {
	
	List<Rumble> getAllRumblesForSpecificUser(int id);

	List<Rumble> getAllRumbles();
	Rumble findRumbleById(int Id);
	Rumble createRumble(Rumble rumble);
	Rumble updateRumble(Rumble rumble);
	boolean deleteRumble(int id);
	
	LocationRating findLocationRatingById(int userId, int locationId);
	public LocationRating createLocationRating(LocationRating LocationRating);
	public List<Location> getAllLocations();
	public List<LocationRating> getLocationRatings(int locationId);
	public List<LocationRating> getAllLocationRatings();
	public List<LocationType> getAllLocationTypes();
	public List<Discipline> getAllDisciplines();
	Discipline findDisciplineById(int id);
	Location findlocationById(int id);
	public LocationRating addRatingToRatingList(int locationId, int userId, LocationRating locationRating);
	boolean deleteLocationRating(int userId, int locationId);
	public boolean enableRumble(int id);
	LocationType findLocoTypeById(int id);
	Location updateLocation(Location location);
	Location createLocation(Location location);
	boolean deleteLocation(int id);
	public boolean enableLocation(int id);
	List<RumbleMessage> getAllRumbleMessages();
	List<RumbleMessage> getAllRumbleMessagesPerRumble(int rumbleId);
	RumbleMessage findRumbleMessageById(int id);
	RumbleMessage createRumbleMessage(RumbleMessage rumbleMessage);
	RumbleMessage updateRumbleMessage(RumbleMessage rumbleMessage);
	boolean deleteRumbleMessage(int id);
	public boolean enableLocationRating(int userId, int locationId);
	public boolean enableRumbleMessage(int id);
}
