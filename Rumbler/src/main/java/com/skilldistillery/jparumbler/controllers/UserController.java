package com.skilldistillery.jparumbler.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jparumbler.data.RumbleDAO;
import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.Rumble;
import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RumbleDAO rumDao;

	@RequestMapping(path = { "/", "home.do" })
	private String goHome(Model model) {
		return "home";
	}

	@RequestMapping(path = { "update.do" }, method = RequestMethod.GET)
	private String getUpdateAccount(User user, HttpSession session) {
		session.getAttribute("loggedInUser");
		return "UpdateUser";
	}

	@RequestMapping(path = { "updateAccount.do" }, method = RequestMethod.POST)
	private String postUpdateAccount(User user, HttpSession session, Model model) {
		User updatedUser = userDao.updateUser(user);
		session.setAttribute("loggedInUser", updatedUser);
		List<Rumble> allUserRumbles = rumDao.getAllRumblesForSpecificUser(user.getId());
		model.addAttribute("allUserRumbles", allUserRumbles);
		List<UserDiscipline> userDisciplines = userDao.findAllDisciplinesForUser(user.getId());
		model.addAttribute("userDisciplines", userDisciplines);
		return "account";
	}

	@RequestMapping(path = { "createAccount.do" }, method = RequestMethod.POST)
	private String createUser(User user, HttpSession session) {
		User newUser = userDao.createUser(user);
		session.setAttribute("loggedInUser", newUser);
		return "account";
	}

	@RequestMapping(path = "accountCreation.do")
	private String createAccountForm(HttpSession session) {
		return "CreateUser";
	}

	@RequestMapping(path = "accountPage.do")
	private String accountPage(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {
		user = userDao.findUserById(user.getId());
		session.setAttribute("loggedInUser", user);
		}
		List<Rumble> allUserRumbles = rumDao.getAllRumblesForSpecificUser(user.getId());
		model.addAttribute("allUserRumbles", allUserRumbles);
		List<UserDiscipline> userDisciplines = userDao.findAllDisciplinesForUser(user.getId());
		model.addAttribute("userDisciplines", userDisciplines);
		return "account";
	}

	@RequestMapping(path = "deletePage.do")
	private String deletePage(HttpSession session) {
		return "deleteAccount";
	}

	@RequestMapping(path = "deleteUser.do")
	private String deleteAccount(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		boolean deleted = userDao.deleteUser(user.getId());
		session.setAttribute("deleted", deleted);
		session.setAttribute("userName", user.getUsername());
		session.removeAttribute("loggedInUser");
		System.out.println(deleted);
		return "home";
	}
	@RequestMapping(path = "findUsersByName.do", params = "name")
	private String findUsersByName(@RequestParam String name, Model model) {
		List<User> users = userDao.findUsersByName(name);
		model.addAttribute("users", users);
		return "ViewOtherUsers";
	}
	@RequestMapping(path = "findUsersByZip.do", params = "zip")
	private String findUsersByZip(@RequestParam String zip, Model model) {
		List<User> users = userDao.findUsersByZip(zip);
		model.addAttribute("users", users);
		return "ViewOtherUsers";
	}
	@RequestMapping(path = "findUsersByDisciplines.do", params = "discipline")
	private String findUsersByDiscipline(@RequestParam String discipline, Model model) {
		List<User> users = userDao.findUsersDiscipline(discipline);
		model.addAttribute("users", users);
		return "ViewOtherUsers";
		
	}
}
