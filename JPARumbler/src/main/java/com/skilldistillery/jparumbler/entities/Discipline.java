package com.skilldistillery.jparumbler.entities;

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
	
	
	

	public List<Rumble> getRumbles() {
		return rumbles;
	}

	public void setRumbles(List<Rumble> rumbles) {
		this.rumbles = rumbles;
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
