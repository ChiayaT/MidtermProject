package com.skilldistillery.jparumbler.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jparumbler.data.RumbleDAO;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.Rumble;

@Controller
public class RumbleController {
	
	@Autowired
	private RumbleDAO rumDao;

	@RequestMapping(path = "makeRumble.do", method=RequestMethod.GET)
	private String goToCreateRumble(HttpSession session) {
		return "CreateRumble";
	}
	
	@RequestMapping(path = "makeRumble.do", method=RequestMethod.POST)
	private String CreateRumble(HttpSession session, Rumble rumble, Location location) {
		Rumble newRumble = rumDao.createRumble(rumble);
		newRumble.setLocation(location);
		
		session.setAttribute("Rumble", newRumble);
		return "Rumble";
	}
	
	@RequestMapping(path = "Rumble.do")
	private String goToRumble(HttpSession session, Rumble rumble) {
		rumble = rumDao.findRumbleById(1);
		session.setAttribute("Rumble", rumble);
		return "Rumble";
	}
	
	@RequestMapping(path = "updateRumble.do")
	private String updateRumble(HttpSession session, Rumble rumble) {
		Rumble updatedRumble = rumDao.updateRumble(rumble);
		session.setAttribute("Rumble", updatedRumble);
		return "Rumble";
	}
	
	@RequestMapping(path = "deleteRumble.do")
	private String deleteRumble(HttpSession session, Rumble rumble) {
		Rumble updatedRumble = rumDao.updateRumble(rumble);
		session.setAttribute("Rumble", null);
		return "Account";
	}
	
	
	
	
	
}
