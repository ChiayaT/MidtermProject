package com.skilldistillery.jparumbler.controllers;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jparumbler.data.RumbleDAO;
import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.User;

@Controller
public class RumbleController {
	
	@Autowired
	private RumbleDAO rumDao;
	
	@Autowired
	private UserDAO dao;

	@RequestMapping(path = "makeRumble.do", method=RequestMethod.GET)
	private String goToCreateRumble(HttpSession session) {
		session.setAttribute("disciplines", rumDao.getAllDisciplines());
		session.setAttribute("locations", rumDao.getAllLocations());
		session.setAttribute("locationTypes",rumDao.getAllLocationTypes());
		session.setAttribute("guest", dao.findUserById(3));
		return "CreateRumble";
	}
	
	@RequestMapping(path = "makeRumble.do", method=RequestMethod.POST)
	private String CreateRumble(HttpSession session, Rumble rumble, Integer locationId, Integer disciplineId) {
		rumble.setHost((User) session.getAttribute("loggedInUser"));
		rumble.setGuest((User) session.getAttribute("guest"));
		if (locationId != null & disciplineId != null) {
		rumble.setLocation(rumDao.findlocationById(locationId));
		rumble.setDiscipline(rumDao.findDisciplineById(disciplineId));
		Rumble newRumble = rumDao.createRumble(rumble);	
		session.setAttribute("Rumble", newRumble);
		session.setAttribute("loggedInUser", rumble.getHost());
		return "Rumble";
		}
		return"CreateRumble";
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
