package com.skilldistillery.jparumbler.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

@Entity
@Table(name = "location_rating")
public class LocationRating {

	@EmbeddedId
	private LocationRatingId id;

	@Column(name = "rating_scale")
	private int ratingScale;

	@Column(name = "rating_comment")
	private String ratingComment;

	@Column(name = "create_date")
	@CreationTimestamp
	private LocalDateTime createDate;

	@Column(name = "last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;

	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "user_id") 
	@MapsId(value = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "location_id") 
	@MapsId(value = "locationId")
	private Location location;

	public LocationRating() {
		super();
	}

	public LocationRatingId getId() {
		return id;
	}

	public void setId(LocationRatingId id) {
		this.id = id;
	}

	public int getRatingScale() {
		return ratingScale;
	}

	public void setRatingScale(int ratingScale) {
		this.ratingScale = ratingScale;
	}

	public String getRatingComment() {
		return ratingComment;
	}

	public void setRatingComment(String ratingComment) {
		this.ratingComment = ratingComment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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
		return "LocationRating [id=" + id + ", ratingScale=" + ratingScale + ", ratingComment=" + ratingComment
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + ", enabled=" + enabled + "]";
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
		LocationRating other = (LocationRating) obj;
		return Objects.equals(id, other.id);
	}

}
