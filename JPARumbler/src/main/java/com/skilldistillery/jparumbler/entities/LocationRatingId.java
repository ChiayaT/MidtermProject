package com.skilldistillery.jparumbler.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocationRatingId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "location_id")
	private int locationId;

	public LocationRatingId() {
		super();
	}

	public LocationRatingId(int userId, int locationId) {
		super();
		this.userId = userId;
		this.locationId = locationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "LocationRatingId [userId=" + userId + ", locationId=" + locationId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationRatingId other = (LocationRatingId) obj;
		return locationId == other.locationId && userId == other.userId;
	}
	
	

}
