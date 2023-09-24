package com.skilldistillery.jparumbler.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//add and remove methods added

@Entity
@Table(name="fighting_stance")
public class FightingStance {

	@Id
	private int id;
	
	private String stance;
	
	private String description;
	
	@OneToMany(mappedBy = "fightingStance")
	private List<UserDiscipline> userDisciplines;

	public FightingStance() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStance() {
		return stance;
	}

	public void setStance(String stance) {
		this.stance = stance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
			if (userDiscipline.getFightingStance() != null) {
				userDiscipline.getFightingStance().removeUserDiscipline(userDiscipline);
			}
			userDiscipline.setFightingStance(this);
		}
	}
	
	public void removeUserDiscipline(UserDiscipline userDiscipline) {
		if(userDisciplines != null && userDisciplines.contains(userDiscipline)) {
			userDisciplines.remove(userDiscipline);
			userDiscipline.setFightingStance(null);
		}
	}

	@Override
	public String toString() {
		return "FightingStance [id=" + id + ", stance=" + stance + ", description=" + description + "]";
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
		FightingStance other = (FightingStance) obj;
		return id == other.id;
	}
	
	
}
