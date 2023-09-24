package com.skilldistillery.jparumbler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
