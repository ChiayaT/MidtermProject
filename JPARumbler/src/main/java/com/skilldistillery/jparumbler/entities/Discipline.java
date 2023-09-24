package com.skilldistillery.jparumbler.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//add and remove methods added

@Entity
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy="discipline")
	private List<UserDiscipline> userDisciplines;
	
	@OneToMany(mappedBy="discipline")
	private List<Rumble> rumbles;

	public Discipline() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
			if (userDiscipline.getDiscipline() != null) {
				userDiscipline.getDiscipline().removeUserDiscipline(userDiscipline);
			}
			userDiscipline.setDiscipline(this);
		}
	}
	
	public void removeUserDiscipline(UserDiscipline userDiscipline) {
		if(userDisciplines != null && userDisciplines.contains(userDiscipline)) {
			userDisciplines.remove(userDiscipline);
			userDiscipline.setDiscipline(null);
		}
	}
	

	public List<Rumble> getRumbles() {
		return rumbles;
	}

	public void setRumbles(List<Rumble> rumbles) {
		this.rumbles = rumbles;
	}
	
	public void addRumble(Rumble rumble) {
		if (rumbles == null) {rumbles = new ArrayList<>(); }
		if (!rumbles.contains(rumble)) {
			rumbles.add(rumble);
			if (rumble.getDiscipline() != null) {
				rumble.getDiscipline().removeRumble(rumble);
			}
			rumble.setDiscipline(this);
		}
	}
	
	public void removeRumble(Rumble rumble) {
		if(rumbles != null && rumbles.contains(rumble)) {
			rumbles.remove(rumble);
			rumble.setDiscipline(null);
		}
	}

	@Override
	public String toString() {
		return "Discipline [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ "]";
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
		Discipline other = (Discipline) obj;
		return id == other.id;
	}
	
	
	

}
