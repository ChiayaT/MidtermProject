package com.skilldistillery.jparumbler.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Rumble {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Column(name="host_rating_comment")
	private String hostRatingComment;
	
	@Column(name="host_rating_scale")
	private String hostRatingScale;
	
	@Column(name="guest_rating_comment")
	private String guestRatingComment;
	
	@Column(name="guest_rating_scale")
	private String guestRatingScale;
	
	@Column(name="rumble_date")
	private LocalDate rumbleDate;
	
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	@Column(name="create_date")
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	private boolean enabled;
	
	@Column(name="open_to_public")
	private Boolean openToPublic;
	
	@ManyToOne
	@JoinColumn(name="host_id")
	private User host;
	
	@ManyToOne
	@JoinColumn(name="guest_id")
	private User guest;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "discipline_id")
	private Discipline discipline;
	
	@OneToMany(mappedBy="rumble")
	private List<RumbleMessage> rumbleMessages;

	public Rumble() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHostRatingComment() {
		return hostRatingComment;
	}

	public void setHostRatingComment(String hostRatingComment) {
		this.hostRatingComment = hostRatingComment;
	}

	public String getHostRatingScale() {
		return hostRatingScale;
	}

	public void setHostRatingScale(String hostRatingScale) {
		this.hostRatingScale = hostRatingScale;
	}

	public String getGuestRatingComment() {
		return guestRatingComment;
	}

	public void setGuestRatingComment(String guestRatingComment) {
		this.guestRatingComment = guestRatingComment;
	}

	public String getGuestRatingScale() {
		return guestRatingScale;
	}

	public void setGuestRatingScale(String guestRatingScale) {
		this.guestRatingScale = guestRatingScale;
	}

	public LocalDate getRumbleDate() {
		return rumbleDate;
	}

	public void setRumbleDate(LocalDate rumbleDate) {
		this.rumbleDate = rumbleDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
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

	public Boolean getOpenToPublic() {
		return openToPublic;
	}

	public void setOpenToPublic(Boolean openToPublic) {
		this.openToPublic = openToPublic;
	}
	
	

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public User getGuest() {
		return guest;
	}

	public void setGuest(User guest) {
		this.guest = guest;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	
	

	public List<RumbleMessage> getRumbleMessages() {
		return rumbleMessages;
	}

	public void setRumbleMessages(List<RumbleMessage> rumbleMessages) {
		this.rumbleMessages = rumbleMessages;
	}

	@Override
	public String toString() {
		return "Rumble [id=" + id + ", title=" + title + ", description=" + description + ", hostRatingComment="
				+ hostRatingComment + ", hostRatingScale=" + hostRatingScale + ", guestRatingComment="
				+ guestRatingComment + ", guestRatingScale=" + guestRatingScale + ", rumbleDate=" + rumbleDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", createDate=" + createDate + ", lastUpdate="
				+ lastUpdate + ", enabled=" + enabled + ", openToPublic=" + openToPublic + "]";
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
		Rumble other = (Rumble) obj;
		return id == other.id;
	}
	
	
}
