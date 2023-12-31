package com.skilldistillery.jparumbler.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jparumbler.data.RumbleDAO;
import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.LocationRating;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;
import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RumbleDAO rumDao;
	
	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String displayLogin(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "index";
		}
		return "login";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String login(User user, HttpSession session, Model model) {
	User loggedInUser = userDao.authenticateUser(user);
	// username and pword match -> return account
		if (loggedInUser != null) {
			// add user to session
			session.setAttribute("loggedInUser", loggedInUser);
			if (loggedInUser.getRole() != null && loggedInUser.getRole().equals("admin")) {
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
				return "admin";
			}
			List<Rumble> allUserRumbles = rumDao.getAllRumblesForSpecificUser(loggedInUser.getId());

			model.addAttribute("allUserRumbles", allUserRumbles);
			List<UserDiscipline> userDisciplines = userDao.findAllDisciplinesForUser(loggedInUser.getId());
			model.addAttribute("userDisciplines", userDisciplines);
			return "account";
		}
		// login fails -> return login
		return "login";
	}

	@RequestMapping(path = "logout.do")
	public String logout(HttpSession session) {
		// remove user from session
		session.removeAttribute("allUserRumbles");
		session.removeAttribute("loggedInUser");
		return "home";
	}
}
