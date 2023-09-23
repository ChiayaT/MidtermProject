package com.skilldistillery.jparumbler.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Entity
@Table(name="location_rating")
public class LocationRating {
	
	
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Id
	@Column(name="location_id")
	private int locationId;
	
	@Column(name="rating_scale")
	private int ratingScale;
	
	@Column(name="rating_comment")
	private int ratingComment;
	
	@Column(name="create_date")
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	private boolean enabled;

	public LocationRating() {
		super();
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

	public int getRatingScale() {
		return ratingScale;
	}

	public void setRatingScale(int ratingScale) {
		this.ratingScale = ratingScale;
	}

	public int getRatingComment() {
		return ratingComment;
	}

	public void setRatingComment(int ratingComment) {
		this.ratingComment = ratingComment;
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

	@Override
	public String toString() {
		return "LocationRating [userId=" + userId + ", locationId=" + locationId + ", ratingScale=" + ratingScale
				+ ", ratingComment=" + ratingComment + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate
				+ ", enabled=" + enabled + "]";
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
		LocationRating other = (LocationRating) obj;
		return locationId == other.locationId && userId == other.userId;
	}
	
	
	
}
