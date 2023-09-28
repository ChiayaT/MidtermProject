package com.skilldistillery.jparumbler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jparumbler.data.RumbleDAO;
import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.User;

@Controller
public class AdminController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RumbleDAO rumDao;

	@RequestMapping(path = { "adminPage.do" })
	private String showAllRumbles(Model model, String disabledRumble, String disabledUser, String disabledLocation) {
		List<Rumble> allRumblesForAllUsers = rumDao.getAllRumbles();
		model.addAttribute("allRumbles", allRumblesForAllUsers);
		List<User> allUsers = userDao.findAllUsers();
		model.addAttribute("allUsers", allUsers);
		List<Location> allLocations = rumDao.getAllLocations();
		model.addAttribute("allLocations", allLocations);
		if(disabledRumble != null && disabledRumble.length() > 0) {
			model.addAttribute("disabledRumble", disabledRumble);
		}
		if(disabledUser != null && disabledUser.length() > 0) {
			model.addAttribute("disabledUser", disabledUser);
		}
		if(disabledLocation != null && disabledLocation.length() > 0) {
			model.addAttribute("disabledLocation", disabledLocation);
		}
		return "admin";
	}

	@RequestMapping(path = { "disableRumble.do" })
	private String disableRumble(Model model, int id) {
		Rumble rumbleToDisable = rumDao.findRumbleById(id);
		rumDao.deleteRumble(rumbleToDisable.getId());
		return "redirect:adminPage.do?disabledRumble=" + rumbleToDisable.getTitle();
	}
	
	@RequestMapping(path = { "disableUser.do" })
	private String disableUser(Model model, int id) {
		User userToDisable = userDao.findUserById(id);
		userDao.deleteUser(userToDisable.getId());
		return "redirect:adminPage.do?disabledUser=" + userToDisable.getUsername();
	}
	
	@RequestMapping(path = { "disableLocation.do" })
	private String disableLocation(Model model, int id) {
		Location locationToDisable = rumDao.findlocationById(id);
		rumDao.deleteLocation(locationToDisable.getId());
		return "redirect:adminPage.do?disabledLocation=" + locationToDisable.getName();
	}
	
}
