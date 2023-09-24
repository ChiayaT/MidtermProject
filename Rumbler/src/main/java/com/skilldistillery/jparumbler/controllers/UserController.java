package com.skilldistillery.jparumbler.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(path = {"/", "home.do"}	)
	private String goHome(Model model) {
	
		return "home";
	}
	
	
	@RequestMapping(path = {"update.do"}, method=RequestMethod.GET)
	private String getUpdateAccount(User user, HttpSession session) {
		session.getAttribute("loggedInUser");
		return "updateUser";
	}
	
	@RequestMapping(path = {"update.do"}, method=RequestMethod.POST)
	private String postUpdateAccount(User user, HttpSession session) {
		session.setAttribute("logginInUser", userDao.updateUser(user));
		return "account";
		
	}
	
	
}
