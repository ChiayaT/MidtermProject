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
import com.skilldistillery.jparumbler.entities.Discipline;
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
	public String goToUpdateDisciplines(HttpSession session, Model model, String updated, String deleted) {
		User user = (User) session.getAttribute("loggedInUser");
		List<UserDiscipline> userDisciplines = userDao.findAllDisciplinesForUser(user.getId());
		model.addAttribute("userDisciplines", userDisciplines);
		List<FightingStance> allStances = disDao.getAllFightingStances();
		model.addAttribute("allStances", allStances);
		List<ExperienceLevel> allLevels = disDao.getAllExperienceLevels();
		model.addAttribute("allLevels", allLevels);
		List<Discipline> allDisciplines = disDao.getAllDisciplines();
		model.addAttribute("allDisciplines", allDisciplines);
		if(updated != null && updated.length() > 0) {
			model.addAttribute("updatedDiscipline", updated);
		}
		if(deleted != null && deleted.length() > 0) {
			model.addAttribute("deletedDiscipline", deleted);
		}
		refreshSessionUser(session);
		return "updateDisciplines";
	}

	@RequestMapping(path = "updateSpecificDiscipline.do", method = RequestMethod.POST)
	public String updateSpecificDiscipline(int userId, int disciplineId, UserDiscipline userDiscipline, HttpSession session) {
	UserDiscipline updatedDiscipline = disDao.updateDiscipline(userDiscipline, userId, disciplineId);
		return "redirect:updateDisciplines.do?updated=" + updatedDiscipline.getDiscipline().getName().replaceAll(" ", "+"); 
	}
	
	@RequestMapping(path = "addNewDiscipline.do", method = RequestMethod.POST)
	public String addNewDiscipline(int disciplineId, UserDiscipline userDiscipline, Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		UserDiscipline newDiscipline = disDao.addNewDiscipline(userDiscipline, user.getId(), disciplineId);
		refreshSessionUser(session);
		return "redirect:updateDisciplines.do"; 
	}
	
	@RequestMapping(path = "deleteDiscipline.do")
	public String deleteDiscipline(int userId, int disciplineId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		UserDisciplineId id = new UserDisciplineId(userId, disciplineId);
		UserDiscipline deletedDiscipline = disDao.findDisciplineById(id);
		disDao.deleteDiscipline(userId, disciplineId);
		session.setAttribute("userDisciplineId", new UserDisciplineId(userId, disciplineId));
		refreshSessionUser(session);
		return "redirect:updateDisciplines.do?deleted=" + deletedDiscipline.getDiscipline().getName().replaceAll(" ", "+");
	}
	
	@RequestMapping(path = "undoDelete.do")
	public String undoDeleteDiscipline(int userId, int disciplineId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		UserDisciplineId id = new UserDisciplineId(userId, disciplineId);
		UserDiscipline undoDeletedDiscipline = disDao.findDisciplineById(id);
		disDao.enableDiscipline(userId, disciplineId);
		session.removeAttribute("userDisciplineId");
		refreshSessionUser(session);
		return "redirect:updateDisciplines.do?updated=" + undoDeletedDiscipline.getDiscipline().getName().replaceAll(" ", "+");
	}
	
	public void refreshSessionUser(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		if (user != null) {
			session.setAttribute("loggedInUser", userDao.findUserById(user.getId()));
		}
		
	}

}
