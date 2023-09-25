package com.skilldistillery.jparumbler.data;

import java.util.List;

import com.skilldistillery.jparumbler.entities.Rumble;

public interface RumbleDAO {

	List<Rumble> getAllRumbles();
	Rumble findRumbleById(int Id);
	Rumble createRumble(Rumble rumble);
	Rumble updateRumble(Rumble rumble);
	boolean deleteRumble(int id);
	
}
