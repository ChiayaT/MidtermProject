package com.skilldistillery.jparumbler.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.User;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;
	
//FIXME - need to write DAO methods first
	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String displayLogin(HttpSession session) {
		if (session.getAttribute("loggedInUser") != null) {
			return "index";
		}
		return "login";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String login(User user, HttpSession session) {
	User loggedInUser = userDao.authenticateUser(user);
	// username and pword match -> return account
		if (loggedInUser != null) {
			// add user to session
			session.setAttribute("loggedInUser", loggedInUser);
			return "account";
		}
		// login fails -> return login
		return "login";
	}

	@RequestMapping(path = "logout.do")
	public String logout(HttpSession session) {
		// remove user from session
		session.removeAttribute("loggedInUser");
		return "home";
	}
}
