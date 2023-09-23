package com.skilldistillery.jparumbler.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="create_date")
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	@OneToMany(mappedBy="location")
	private List<LocationRating> locationRatings;
	
	@ManyToOne
	@JoinColumn(name="location_type_id")
	private LocationType locationType;

	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy="location")
	private List<Rumble> rumbles;
	
	
	private boolean enabled;

	public Location() {
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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<LocationRating> getLocationRatings() {
		return locationRatings;
	}

	public void setLocationRatings(List<LocationRating> locationRatings) {
		this.locationRatings = locationRatings;
	}
	
	
	

	public List<Rumble> getRumbles() {
		return rumbles;
	}

	public void setRumbles(List<Rumble> rumbles) {
		this.rumbles = rumbles;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		Location other = (Location) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", description=" + description + ", image_url=" + image_url
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + ", enabled=" + enabled + "]";
	}
	
	
	
}
