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
@Table(name = "location_type")
public class LocationType {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
	
		private String description;
		
		@OneToMany(mappedBy = "locationType")
		private List<Location> locations;
	
	
	

	public LocationType() {
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
	
	

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	public void addLocation(Location location) {
		if (locations == null) {locations = new ArrayList<>(); }
		if (!locations.contains(location)) {
			locations.add(location);
			if (location.getLocationType() != null) {
				location.getLocationType().removeLocation(location);
			}
			location.setLocationType(this);
		}
	}
	
	public void removeLocation(Location location) {
		if(locations != null && locations.contains(location)) {
			locations.remove(location);
			location.setLocationType(null);
		}
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
		LocationType other = (LocationType) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "LocationType [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	

}
