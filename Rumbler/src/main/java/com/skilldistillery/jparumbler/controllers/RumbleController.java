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
import com.skilldistillery.jparumbler.entities.Discipline;
import com.skilldistillery.jparumbler.entities.Location;
import com.skilldistillery.jparumbler.entities.LocationRating;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.RumbleMessage;
import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;

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
		if ((locationId != null & disciplineId != null) || !location.getName().equals("null")) {
			if (locationId != null & disciplineId != null) {
				rumble.setLocation(rumDao.findlocationById(locationId));
			} else {
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
		rumble.setRumbleMessages(rumDao.getAllRumbleMessagesPerRumble(rumble.getId()));

		session.setAttribute("Rumble", rumble);
		return "Rumble";
	}

	@RequestMapping(path = "updateRumble.do", method = RequestMethod.GET)
	private String gotoupdateRumble(int rumbleId, Model model, HttpSession session) {
		Rumble rumble = rumDao.findRumbleById(rumbleId);
		session.setAttribute("Rumble", rumble);
		model.addAttribute("location", rumble.getLocation());
		model.addAttribute("locations", rumDao.getAllLocations());
		model.addAttribute("locationTypes", rumDao.getAllLocationTypes());
		model.addAttribute("disciplines", rumDao.getAllDisciplines());

		return "updateRumble";
	}

	@RequestMapping(path = "updateRumble.do", method = RequestMethod.POST)
	private String updateRumble(HttpSession session, Rumble rumble, Integer locationId, Integer disciplineId,
			Location location, Integer locationTypeId, String descriptionLoco, String descriptionRum) {
		Rumble managedRumble = (Rumble) session.getAttribute("Rumble");
		rumble.setDescription(descriptionRum);
		location.setDescription(descriptionLoco);
		rumble.setHost(managedRumble.getHost());
		rumble.setGuest(managedRumble.getGuest());
		rumble.setId(managedRumble.getId());
		System.out.println(rumble);
		if ((locationId != null & disciplineId != null) || !location.getName().equals("Only Change If Creating")) {
			if (locationId != null & disciplineId != null) {
				rumble.setLocation(rumDao.findlocationById(locationId));
			} else {
				location.setLocationType(rumDao.findLocoTypeById(locationTypeId));
				rumDao.createLocation(location);
				rumble.setLocation(location);
			}
		}
		System.out.println(rumble.getGuest());
		System.out.println(rumble.getHost());
		Discipline discipline = rumDao.findDisciplineById(disciplineId);
		if (rumble.getDiscipline() != discipline) {
			rumble.setDiscipline(discipline);
		}
		rumble.setRumbleMessages(rumDao.getAllRumbleMessagesPerRumble(rumble.getId()));

		Rumble updatedRumble = rumDao.updateRumble(rumble);
		session.setAttribute("Rumble", updatedRumble);
		return "Rumble";
	}

	@RequestMapping(path = "goToDeleteRumble.do")
	private String gotodeleteRumble(HttpSession session, Integer rumbleId, Model model) {
		model.addAttribute("Rumble", rumDao.findRumbleById(rumbleId));
		return "deleteRumble";
	}

	@RequestMapping(path = "deleteRumble.do")
	private String deleteRumble(HttpSession session, Integer rumbleId, Model model) {
		User user = ((User) session.getAttribute("loggedInUser"));
		rumDao.deleteRumble(rumbleId);
		session.removeAttribute("Rumble");
		List<Rumble> allUserRumbles = rumDao.getAllRumblesForSpecificUser(user.getId());
		model.addAttribute("allUserRumbles", allUserRumbles);
		List<UserDiscipline> userDisciplines = dao.findAllDisciplinesForUser(user.getId());
		model.addAttribute("userDisciplines", userDisciplines);
		return "account";
	}

	@RequestMapping(path = "getLocationsList.do")
	private String getLocationsList(Model model, HttpSession session) {
		List<Location> locations = rumDao.getAllLocations();
		model.addAttribute("locations", locations);
		session.setAttribute("locationTypes", rumDao.getAllLocationTypes());
		return "LocationsList";

	}

	@RequestMapping(path = "getLocation.do")
	private String getLocation(Model model, int locationId, HttpSession session) {
		Location location = rumDao.findlocationById(locationId);
		model.addAttribute("location", location);
		model.addAttribute("locationRatings", location.getLocationRatings());
		refreshSessionUser(session);
		return "Location";
	}

	@RequestMapping(path = "giveLocationRating.do", method = RequestMethod.GET)
	private String giveLocationRatingGet(HttpSession session, Model model, int locationId) {
		Location location = rumDao.findlocationById(locationId);
		session.setAttribute("location", location);
		return "CreateLocationReview";
	}

	@RequestMapping(path = "giveLocationRating.do", method = RequestMethod.POST)
	private String giveLocationRatingPost(HttpSession session, Model model, Integer locationId,
			LocationRating locationRating) {
		User currentUser = (User) session.getAttribute("loggedInUser");
		if (currentUser != null) {
			locationRating = rumDao.addRatingToRatingList(locationId, currentUser.getId(), locationRating);
			refreshSessionUser(session);
			Location location = rumDao.findlocationById(locationId);
			System.out.println(location.getLocationRatings());
		}
		return "redirect:getLocation.do?locationId=" + locationRating.getLocation().getId();
	}

	@RequestMapping(path = "updateLocationPage.do")
	private String updateLocationPage(HttpSession session, Model model, int locationId) {
		Location location = rumDao.findlocationById(locationId);
		model.addAttribute("location", location);
		model.addAttribute("locationId", locationId);
		return "UpdateLocation";
	}

	@RequestMapping(path = "updateLocation.do", method = RequestMethod.POST)
	private String updateLocation(HttpSession session, Model model, Location location) {
		rumDao.updateLocation(location);
		session.setAttribute("location", location);
		session.getAttribute("locationRatings");
		return "redirect:getLocation.do?locationId=" + location.getId();
	}

	@RequestMapping(path = "createLocation.do", method = RequestMethod.POST)
	private String createLocation(HttpSession session, Model model, Location location, int locationTypeId) {
		location.setLocationType(rumDao.findLocoTypeById(locationTypeId));
		Location newLocation = rumDao.createLocation(location);
		return "redirect:getLocationsList.do";
	}

	@RequestMapping(path = "createMessage.do")
	private String createMessage(HttpSession session, Integer userId, Integer rumbleId, Model model) {
		Rumble rumble = rumDao.findRumbleById(rumbleId);
		User user = dao.findUserById(userId);
		model.addAttribute("user", user);
		rumble.setRumbleMessages(rumDao.getAllRumbleMessagesPerRumble(rumble.getId()));
		model.addAttribute("rumble", rumble);
		return "createRumbleMessage";
	}

	@RequestMapping(path = "createdMessage.do")
	private String createdMessage(HttpSession session, Integer userId, Integer rumbleId, Model model,
			RumbleMessage message) {
		message.setUser(dao.findUserById(userId));
		message.setRumble(rumDao.findRumbleById(rumbleId));
		Rumble rumble = rumDao.findRumbleById(message.getRumble().getId());
		message = rumDao.createRumbleMessage(message);
		rumble.addRumbleMessage(message);
		User user = dao.findUserById(userId);
		model.addAttribute("user", user);
		rumble.setRumbleMessages(rumDao.getAllRumbleMessagesPerRumble(rumble.getId()));
		session.setAttribute("Rumble", rumble);
		return "Rumble";
	}

	@RequestMapping(path = "updateMessage.do", method = RequestMethod.GET)
	private String gotoupdateMessage(HttpSession session, Integer messageId, Model model) {
		RumbleMessage message = rumDao.findRumbleMessageById(messageId);
		model.addAttribute("message", message);

		return "updateRumbleMessage";
	}

	@RequestMapping(path = "updateMessage.do", method = RequestMethod.POST)
	private String giveLocationRatingPost(HttpSession session, Model model, RumbleMessage message) {

		message = rumDao.updateRumbleMessage(message);
		Rumble rumble = rumDao.findRumbleById(message.getRumble().getId());
		rumble.setRumbleMessages(rumDao.getAllRumbleMessagesPerRumble(rumble.getId()));
		session.setAttribute("Rumble", rumble);

		return "Rumble";

	}

	@RequestMapping(path = "deleteMessage.do")
	private String deleteMessage(HttpSession session, Model model, int messageId) {

		rumDao.deleteRumbleMessage(messageId);
		RumbleMessage message = rumDao.findRumbleMessageById(messageId);
		Rumble rumble = rumDao.findRumbleById(message.getRumble().getId());
		rumble.setRumbleMessages(rumDao.getAllRumbleMessagesPerRumble(rumble.getId()));

		session.setAttribute("Rumble", rumble);

		return "Rumble";

	}
	
	public void refreshSessionUser(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {
			User refreshedUser = dao.findUserById(user.getId());
			refreshedUser.getLocationRatings().size();
			session.setAttribute("loggedInUser", refreshedUser);
		}
		
	}

}
