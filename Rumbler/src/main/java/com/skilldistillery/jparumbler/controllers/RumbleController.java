package com.skilldistillery.jparumbler.controllers;


import java.time.LocalTime;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(path = "makeRumble.do", method = RequestMethod.GET)

	private String goToCreateRumble(HttpSession session, Integer guestId) {

		
		session.setAttribute("disciplines", rumDao.getAllDisciplines());
		session.setAttribute("locations", rumDao.getAllLocations());
		session.setAttribute("locationTypes", rumDao.getAllLocationTypes());

		session.setAttribute("guest", dao.findUserById(guestId));
		return "CreateRumble";
	}

	@RequestMapping(path = "makeRumble.do", method = RequestMethod.POST)
	private String CreateRumble(HttpSession session, Rumble rumble, Integer locationId, Integer disciplineId,

			Location location, Integer locationTypeId) {
		rumble.setHost((User) session.getAttribute("loggedInUser"));
		rumble.setGuest((User) session.getAttribute("guest"));
		rumble.setDiscipline(rumDao.findDisciplineById(disciplineId));
		if ((locationId != null & disciplineId != null) || ! location.getName().equals("null")) {
			if (locationId != null & disciplineId != null) {
				rumble.setLocation(rumDao.findlocationById(locationId));
			}
			else {
				location.setLocationType(rumDao.findLocoTypeById(locationTypeId));
				rumDao.createLocation(location);
				rumble.setLocation(location); 
			}
			Rumble newRumble = rumDao.createRumble(rumble);
			session.setAttribute("Rumble", newRumble);
			session.setAttribute("loggedInUser", rumble.getHost());
			return "Rumble";
		}
		return "CreateRumble";
	}
	
	@RequestMapping(path = "Rumble.do")
	private String goToRumble(HttpSession session, Rumble rumble, Integer id) {
		rumble = rumDao.findRumbleById(id);
		session.setAttribute("Rumble", rumble);
		return "Rumble";
	}

	
	@RequestMapping(path = "updateRumble.do" ,method = RequestMethod.GET)
	private String gotoupdateRumble(HttpSession session, Rumble rumble, Model model) {
		model.addAttribute("location", rumble.getLocation());
		model.addAttribute("locations", rumDao.getAllLocations());
		model.addAttribute("locationTypes", rumDao.getAllLocationTypes());
		model.addAttribute("disciplines", rumDao.getAllDisciplines());
		
		return "updateRumble";
	}

	@RequestMapping(path = "updateRumble.do" ,method = RequestMethod.POST)
	private String updateRumble(HttpSession session, Rumble rumble, Integer locationId, Integer disciplineId,
			Location location, Integer locationTypeId, String descriptionLoco, String descriptionRum) {
		Rumble managedRumble = (Rumble) session.getAttribute("Rumble");
		rumble.setDescription(descriptionRum);
		location.setDescription(descriptionLoco);
		rumble.setHost(managedRumble.getHost());
		rumble.setGuest(managedRumble.getGuest());
		if ((locationId != null & disciplineId != null) || ! location.getName().equals("Only Change If Creating")) {
			if (locationId != null & disciplineId != null) {
				System.out.println(location.getId());
				rumble.setLocation(rumDao.findlocationById(locationId));
			}
			else {
				location.setLocationType(rumDao.findLocoTypeById(locationTypeId));
				rumDao.createLocation(location);
				rumble.setLocation(location); 
			}
		}
		System.out.println(rumble.getGuest());
		System.out.println(rumble.getHost());
		Discipline discipline = rumDao.findDisciplineById(disciplineId);
		if(rumble.getDiscipline() != discipline) {
			rumble.setDiscipline(discipline);
		}
		

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
	
	 @RequestMapping(path = "getLocationsList.do")
	 private String getLocationsList(Model model) {
		 List<Location> locations = rumDao.getAllLocations();
		 model.addAttribute("locations", locations);
		return "LocationsList";
		 
	 }
	 @RequestMapping(path = "getLocation.do")
	 private String getLocation(Model model, int locationId) {
		 Location location = rumDao.findlocationById(locationId);
		 model.addAttribute("location", location);
		return "Location";
	 }

}
