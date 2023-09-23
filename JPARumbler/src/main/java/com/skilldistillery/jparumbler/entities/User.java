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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;
	private boolean enabled;
	private String role;
	
	

	
	@OneToMany(mappedBy="user")
	private List<LocationRating> locationRatings;
	
	@OneToMany(mappedBy="user")
	private List<UserDiscipline> userDisciplines;
	
	@OneToMany(mappedBy = "user")
	private List<BlogPost> blogPosts;
	
	@OneToMany(mappedBy = "senderUser")
	private List<DirectMessage> senderMessages;
	
	@OneToMany(mappedBy = "recipientUser")
	private List<DirectMessage> recipientMessages;
	
	@OneToMany(mappedBy = "host")
	private List<Rumble> hostRumbles;
	
	@OneToMany(mappedBy = "guest")
	private List<Rumble> guestRumbles;
	
	@OneToMany(mappedBy = "user")
	private List<RumbleMessage> rumbleMessages;
	
	
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "profile_image_url")
	private String profileImageURL;
	
	@Column(name = "height_in_inches")
	private int heightInInches;
	
	@Column(name = "weight_in_pounds")
	private int weightInPounds;
	
	
	@Column(name = "create_date")
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	private String description;
	

	public User() {
		super();
	}
	
	


	public List<Rumble> getHostRumbles() {
		return hostRumbles;
	}




	public void setHostRumbles(List<Rumble> hostRumbles) {
		this.hostRumbles = hostRumbles;
	}




	public List<Rumble> getGuestRumbles() {
		return guestRumbles;
	}




	public void setGuestRumbles(List<Rumble> guestRumbles) {
		this.guestRumbles = guestRumbles;
	}




	public List<DirectMessage> getSenderMessages() {
		return senderMessages;
	}


	public void setSenderMessages(List<DirectMessage> senderMessages) {
		this.senderMessages = senderMessages;
	}


	public List<DirectMessage> getRecipientMessages() {
		return recipientMessages;
	}


	public void setRecipientMessages(List<DirectMessage> recipientMessages) {
		this.recipientMessages = recipientMessages;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<LocationRating> getLocationRatings() {
		return locationRatings;
	}

	public void setLocationRatings(List<LocationRating> locationRatings) {
		this.locationRatings = locationRatings;
	}

	public List<UserDiscipline> getUserDisciplines() {
		return userDisciplines;
	}

	public void setUserDisciplines(List<UserDiscipline> userDisciplines) {
		this.userDisciplines = userDisciplines;
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}

	public void setBlogPosts(List<BlogPost> blogPosts) {
		this.blogPosts = blogPosts;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileImageURL() {
		return profileImageURL;
	}

	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}

	public int getHeightInInches() {
		return heightInInches;
	}

	public void setHeightInInches(int heightInInches) {
		this.heightInInches = heightInInches;
	}

	public int getWeightInPounds() {
		return weightInPounds;
	}

	public void setWeightInPounds(int weightInPounds) {
		this.weightInPounds = weightInPounds;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + "]";
	}




	public List<RumbleMessage> getRumbleMessages() {
		return rumbleMessages;
	}




	public void setRumbleMessages(List<RumbleMessage> rumbleMessages) {
		this.rumbleMessages = rumbleMessages;
	}
	
	

}
