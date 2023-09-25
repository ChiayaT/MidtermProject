package com.skilldistillery.jparumbler.data;

import java.util.List;

import com.skilldistillery.jparumbler.entities.Address;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;

public interface RumbleDAO {

	List<Rumble> getAllRumbles();
	Rumble findRumbleById(int Id);
	Rumble createRumble(Rumble rumble);
	Rumble updateRumble(Rumble rumble);
	boolean deleteRumble(int id);
	
	List<RumbleMessage> getAllRumbleMessagesPerRumble(int rumbleId);
	RumbleMessage findRumbleMessageById(int id);
	RumbleMessage createRumbleMessage(RumbleMessage rumbleMessage);
	RumbleMessage updateRumbleMessage(RumbleMessage rumbleMessage);
	boolean deleteRumbleMessage(int id);
	
	
}
