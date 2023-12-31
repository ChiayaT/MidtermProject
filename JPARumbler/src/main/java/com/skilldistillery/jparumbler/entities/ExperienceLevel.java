package com.skilldistillery.jparumbler.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//add and remove methods added

@Entity
@Table(name="experience_level")
public class ExperienceLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "experienceLevel")
	private List<UserDiscipline> userDisciplines;

	
	public ExperienceLevel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserDiscipline> getUserDisciplines() {
		return userDisciplines;
	}

	public void setUserDisciplines(List<UserDiscipline> userDisciplines) {
		this.userDisciplines = userDisciplines;
	}
	
	public void addUserDiscipline(UserDiscipline userDiscipline) {
		if (userDisciplines == null) {userDisciplines = new ArrayList<>(); }
		if (!userDisciplines.contains(userDiscipline)) {
			userDisciplines.add(userDiscipline);
			if (userDiscipline.getExperienceLevel() != null) {
				userDiscipline.getExperienceLevel().removeUserDiscipline(userDiscipline);
			}
			userDiscipline.setExperienceLevel(this);
		}
	}
	
	public void removeUserDiscipline(UserDiscipline userDiscipline) {
		if(userDisciplines != null && userDisciplines.contains(userDiscipline)) {
			userDisciplines.remove(userDiscipline);
			userDiscipline.setExperienceLevel(null);
		}
	}

	@Override
	public String toString() {
		return "ExperienceLevel [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExperienceLevel other = (ExperienceLevel) obj;
		return id == other.id;
	}
	
	
	
	
	
	
}
