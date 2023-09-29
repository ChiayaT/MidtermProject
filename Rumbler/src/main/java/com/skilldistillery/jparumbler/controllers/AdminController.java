package com.skilldistillery.jparumbler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jparumbler.data.RumbleDAO;
import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.LocationRating;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;
import com.skilldistillery.jparumbler.entities.User;

@Controller
public class AdminController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RumbleDAO rumDao;

	@RequestMapping(path = { "adminPage.do" })
	private String showAllRumbles(Model model, String disabledRumble, String enabledRumble,
			String disabledUser, String enabledUser, String disabledLocation, 
			String enabledLocation, String disabledLocationRating, String enabledLocationRating,
			String disabledRumbleMessage, String enabledRumbleMessage) {
		List<Rumble> allRumblesForAllUsers = rumDao.getAllRumbles();
		model.addAttribute("allRumbles", allRumblesForAllUsers);
		List<User> allUsers = userDao.findAllUsers();
		model.addAttribute("allUsers", allUsers);
		List<Location> allLocations = rumDao.getAllLocations();
		model.addAttribute("allLocations", allLocations);
		List<LocationRating> allLocationRatings = rumDao.getAllLocationRatings();
		model.addAttribute("allLocationRatings", allLocationRatings);
		List<RumbleMessage> allRumbleMessages = rumDao.getAllRumbleMessages();
		model.addAttribute("allRumbleMessages", allRumbleMessages);
		if(disabledRumble != null && disabledRumble.length() > 0) {
			model.addAttribute("disabledRumble", disabledRumble);
		}
		if(disabledUser != null && disabledUser.length() > 0) {
			model.addAttribute("disabledUser", disabledUser);
		}
		if(disabledLocation != null && disabledLocation.length() > 0) {
			model.addAttribute("disabledLocation", disabledLocation);
		}
		if(disabledLocationRating != null && disabledLocationRating.length() > 0) {
			model.addAttribute("disabledLocationRating", disabledLocationRating);
		}
		if(disabledRumbleMessage != null && disabledRumbleMessage.length() > 0) {
			model.addAttribute("disabledRumbleMessage", disabledRumbleMessage);
		}
		if(enabledRumble != null && enabledRumble.length() > 0) {
			model.addAttribute("enabledRumble", enabledRumble);
		}
		if(enabledUser != null && enabledUser.length() > 0) {
			model.addAttribute("enabledUser", enabledUser);
		}
		if(enabledLocation != null && enabledLocation.length() > 0) {
			model.addAttribute("enabledLocation", enabledLocation);
		}
		if(enabledLocationRating != null && enabledLocationRating.length() > 0) {
			model.addAttribute("enabledLocationRating", enabledLocationRating);
		}
		if(enabledRumbleMessage != null && enabledRumbleMessage.length() > 0) {
			model.addAttribute("enabledRumbleMessage", enabledRumbleMessage);
		}
		return "admin";
	}

	@RequestMapping(path = { "disableRumble.do" })
	private String disableRumble(Model model, int id) {
		Rumble rumbleToDisable = rumDao.findRumbleById(id);
		rumDao.deleteRumble(rumbleToDisable.getId());
		return "redirect:adminPage.do?disabledRumble=" + rumbleToDisable.getTitle();
	}
	@RequestMapping(path = { "enableRumble.do" })
	private String enableRumble(Model model, int id) {
		Rumble rumbleToEnable = rumDao.findRumbleById(id);
		rumDao.enableRumble(rumbleToEnable.getId());
		return "redirect:adminPage.do?enabledRumble=" + rumbleToEnable.getTitle();
	}
	
	@RequestMapping(path = { "disableUser.do" })
	private String disableUser(Model model, int id) {
		User userToDisable = userDao.findUserById(id);
		userDao.deleteUser(userToDisable.getId());
		return "redirect:adminPage.do?disabledUser=" + userToDisable.getUsername();
	}
	@RequestMapping(path = { "enableUser.do" })
	private String enableUser(Model model, int id) {
		User userToEnable = userDao.findUserById(id);
		userDao.enableUser(userToEnable.getId());
		return "redirect:adminPage.do?enabledUser=" + userToEnable.getUsername();
	}
	
	@RequestMapping(path = { "disableLocation.do" })
	private String disableLocation(Model model, int id) {
		Location locationToDisable = rumDao.findlocationById(id);
		rumDao.deleteLocation(locationToDisable.getId());
		return "redirect:adminPage.do?disabledLocation=" + locationToDisable.getName();
	}
	@RequestMapping(path = { "enableLocation.do" })
	private String enableLocation(Model model, int id) {
		Location locationToEnable = rumDao.findlocationById(id);
		rumDao.enableLocation(locationToEnable.getId());
		return "redirect:adminPage.do?enabledLocation=" + locationToEnable.getName();
	}
	
	@RequestMapping(path = { "disableLocationRating.do" })
	private String disableLocationRating(Model model, int userId, int locationId) {
		LocationRating locationRatingToDisable = rumDao.findLocationRatingById(userId, locationId);
		rumDao.deleteLocationRating(userId, locationId);
		return "redirect:adminPage.do?disabledLocationRating=" + locationRatingToDisable.getId().getUserId();
	}
	@RequestMapping(path = { "enableLocationRating.do" })
	private String enableLocationRating(Model model, int userId, int locationId) {
		LocationRating locationRatingToEnable = rumDao.findLocationRatingById(userId, locationId);
		rumDao.enableLocationRating(userId, locationId);
		return "redirect:adminPage.do?enabledLocationRating=" + locationRatingToEnable.getId().getUserId();
	}
	
	@RequestMapping(path = { "disableRumbleMessage.do" })
	private String disableRumbleMessage(Model model, int id) {
		RumbleMessage rumbleMessageToDisable = rumDao.findRumbleMessageById(id);
		rumDao.deleteRumbleMessage(id);
		return "redirect:adminPage.do?disabledRumbleMessage=" + rumbleMessageToDisable.getId();
	}
	@RequestMapping(path = { "enableRumbleMessage.do" })
	private String enableRumbleMessage(Model model, int id) {
		RumbleMessage rumbleMessageToEnable = rumDao.findRumbleMessageById(id);
		rumDao.enableRumbleMessage(id);
		return "redirect:adminPage.do?enabledRumbleMessage=" + rumbleMessageToEnable.getId();
	}
	
}
