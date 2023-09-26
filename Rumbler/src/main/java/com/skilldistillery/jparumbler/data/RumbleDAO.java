package com.skilldistillery.jparumbler.data;

import java.util.List;

import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.LocationType;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;

public interface RumbleDAO {

	List<Rumble> getAllRumbles();
	Rumble findRumbleById(int Id);
	Rumble createRumble(Rumble rumble);
	Rumble updateRumble(Rumble rumble);
	boolean deleteRumble(int id);
	
	public List<Location> getAllLocations();
	public List<LocationType> getAllLocationTypes();
	public List<Discipline> getAllDisciplines();
	Discipline findDisciplineById(int id);
	Location findlocationById(int id);
	
	List<RumbleMessage> getAllRumbleMessagesPerRumble(int rumbleId);
	RumbleMessage findRumbleMessageById(int id);
	RumbleMessage createRumbleMessage(RumbleMessage rumbleMessage);
	RumbleMessage updateRumbleMessage(RumbleMessage rumbleMessage);
	boolean deleteRumbleMessage(int id);
	
	
}
