package com.skilldistillery.jparumbler.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jparumbler.data.DisciplineDAO;
import com.skilldistillery.jparumbler.data.UserDAO;
import com.skilldistillery.jparumbler.entities.ExperienceLevel;
import com.skilldistillery.jparumbler.entities.FightingStance;
import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;
import com.skilldistillery.jparumbler.entities.UserDisciplineId;

@Controller
public class DisciplineController {

	@Autowired
	private DisciplineDAO disDao;

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = "updateDisciplines.do", method = RequestMethod.GET)
	public String goToUpdateDisciplines(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		List<UserDiscipline> userDisciplines = userDao.findAllDisciplinesForUser(user.getId());
		model.addAttribute("userDisciplines", userDisciplines);
		List<FightingStance> allStances = disDao.getAllFightingStances();
		model.addAttribute("allStances", allStances);
		List<ExperienceLevel> allLevels = disDao.getAllExperienceLevels();
		model.addAttribute("allLevels", allLevels);
		return "updateDisciplines";
	}

	@RequestMapping(path = "updateSpecificDiscipline.do", method = RequestMethod.POST)
	public String updateSpecificDiscipline(UserDisciplineId id, UserDiscipline userDiscipline, HttpSession session) {
		UserDiscipline updatedDiscipline = disDao.updateDiscipline(userDiscipline);
//		User user = (User) session.getAttribute("loggedInUser");
//		user.setu
		return "updateDisciplines"; 
	}

}