package com.skilldistillery.jparumbler.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!Complete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//add and remove methods added

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;
	private boolean enabled;
	private String role;

	@OneToMany(mappedBy = "user")
	private List<LocationRating> locationRatings;

	@OneToMany(mappedBy = "user")
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

	@ManyToMany
	@JoinTable(name = "user_has_friend", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
	private List<User> friends;

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

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	public User() {
		super();
	}

	public List<Rumble> getHostRumbles() {
		return hostRumbles;
	}

	public void setHostRumbles(List<Rumble> hostRumbles) {
		this.hostRumbles = hostRumbles;
	}

	public void addHostRumble(Rumble hostRumble) {
		if (hostRumbles == null) {
			hostRumbles = new ArrayList<>();
		}
		if (!hostRumbles.contains(hostRumble)) {
			hostRumbles.add(hostRumble);
			if (hostRumble.getHost() != null) {
				hostRumble.getHost().removeHostRumble(hostRumble);
			}
			hostRumble.setHost(this);
		}
	}

	public void removeHostRumble(Rumble hostRumble) {
		if (hostRumbles != null && hostRumbles.contains(hostRumble)) {
			hostRumbles.remove(hostRumble);
			hostRumble.setHost(null);
		}
	}

	public List<Rumble> getGuestRumbles() {
		return guestRumbles;
	}

	public void setGuestRumbles(List<Rumble> guestRumbles) {
		this.guestRumbles = guestRumbles;
	}

	public void addGuestRumble(Rumble guestRumble) {
		if (guestRumbles == null) {
			guestRumbles = new ArrayList<>();
		}
		if (!guestRumbles.contains(guestRumble)) {
			guestRumbles.add(guestRumble);
			if (guestRumble.getGuest() != null) {
				guestRumble.getGuest().removeGuestRumble(guestRumble);
			}
			guestRumble.setGuest(this);
		}
	}

	public void removeGuestRumble(Rumble guestRumble) {
		if (guestRumbles != null && guestRumbles.contains(guestRumble)) {
			guestRumbles.remove(guestRumble);
			guestRumble.setGuest(null);
		}
	}

	public List<DirectMessage> getSenderMessages() {
		return senderMessages;
	}

	public void setSenderMessages(List<DirectMessage> senderMessages) {
		this.senderMessages = senderMessages;
	}

	public void addSenderMessage(DirectMessage senderMessage) {
		if (senderMessages == null) {
			senderMessages = new ArrayList<>();
		}
		if (!senderMessages.contains(senderMessage)) {
			senderMessages.add(senderMessage);
			if (senderMessage.getSenderUser() != null) {
				senderMessage.getSenderUser().removeSenderMessage(senderMessage);
			}
			senderMessage.setSenderUser(this);
		}
	}

	public void removeSenderMessage(DirectMessage senderMessage) {
		if (senderMessages != null && senderMessages.contains(senderMessage)) {
			senderMessages.remove(senderMessage);
			senderMessage.setSenderUser(null);
		}
	}

	public List<DirectMessage> getRecipientMessages() {
		return recipientMessages;
	}

	public void setRecipientMessages(List<DirectMessage> recipientMessages) {
		this.recipientMessages = recipientMessages;
	}

	public void addRecipientMessage(DirectMessage recipientMessage) {
		if (recipientMessages == null) {
			recipientMessages = new ArrayList<>();
		}
		if (!recipientMessages.contains(recipientMessage)) {
			recipientMessages.add(recipientMessage);
			if (recipientMessage.getRecipientUser() != null) {
				recipientMessage.getRecipientUser().removeRecipientMessage(recipientMessage);
			}
			recipientMessage.setRecipientUser(this);
		}
	}

	public void removeRecipientMessage(DirectMessage recipientMessage) {
		if (recipientMessages != null && recipientMessages.contains(recipientMessage)) {
			recipientMessages.remove(recipientMessage);
			recipientMessage.setRecipientUser(null);
		}
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public void addFriend(User friend) {
		if (friends == null) {
			friends = new ArrayList<>();
		}
		if (!friends.contains(friend) && (friend != this)) {
			friends.add(friend);
			friend.addFriend(this);
		}
	}

	public void removeFriend(User friend) {
		if (friends != null && friends.contains(friend)) {
			friends.remove(friend);
			friend.removeFriend(this);
		}
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

	public void addLocationRating(LocationRating locationRating) {
		if (locationRatings == null) {
			locationRatings = new ArrayList<>();
		}
		if (!locationRatings.contains(locationRating)) {
			locationRatings.add(locationRating);
			if (locationRating.getUser() != null) {
				locationRating.getUser().removeLocationRating(locationRating);
			}
			locationRating.setUser(this);
		}
	}

	public void removeLocationRating(LocationRating locationRating) {
		if (locationRatings != null && locationRatings.contains(locationRating)) {
			locationRatings.remove(locationRating);
			locationRating.setUser(null);
		}
	}

	public List<UserDiscipline> getUserDisciplines() {
		return userDisciplines;
	}

	public void setUserDisciplines(List<UserDiscipline> userDisciplines) {
		this.userDisciplines = userDisciplines;
	}

	public void addUserDiscipline(UserDiscipline userDiscipline) {
		if (userDisciplines == null) {
			userDisciplines = new ArrayList<>();
		}
		if (!userDisciplines.contains(userDiscipline)) {
			userDisciplines.add(userDiscipline);
			if (userDiscipline.getUser() != null) {
				userDiscipline.getUser().removeUserDiscipline(userDiscipline);
			}
			userDiscipline.setUser(this);
		}
	}

	public void removeUserDiscipline(UserDiscipline userDiscipline) {
		if (userDisciplines != null && userDisciplines.contains(userDiscipline)) {
			userDisciplines.remove(userDiscipline);
			userDiscipline.setUser(null);
		}
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}

	public void setBlogPosts(List<BlogPost> blogPosts) {
		this.blogPosts = blogPosts;
	}

	public void addBlogPost(BlogPost blogPost) {
		if (blogPosts == null) {
			blogPosts = new ArrayList<>();
		}
		if (!blogPosts.contains(blogPost)) {
			blogPosts.add(blogPost);
			if (blogPost.getUser() != null) {
				blogPost.getUser().removeBlogPost(blogPost);
			}
			blogPost.setUser(this);
		}
	}

	public void removeBlogPost(BlogPost blogPost) {
		if (blogPosts != null && blogPosts.contains(blogPost)) {
			blogPosts.remove(blogPost);
			blogPost.setUser(null);
		}
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean hasDiscipline(int disciplineId) {
		boolean hasDiscipline = false;
		for (UserDiscipline ud : userDisciplines) {
			if (ud.getDiscipline().getId() == disciplineId) {
				hasDiscipline = true;
				break;
			}
		}
		return hasDiscipline;
	}

	public boolean hasRatedLocation(int userId) {
		boolean hasRated = false;
		for(LocationRating lr : locationRatings) {
			if (lr.getUser().getId() == userId) {
				hasRated = true;
				break;
			}
		}
		return hasRated;
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

	public void addRumbleMessage(RumbleMessage rumbleMessage) {
		if (rumbleMessages == null) {
			rumbleMessages = new ArrayList<>();
		}
		if (!rumbleMessages.contains(rumbleMessage)) {
			rumbleMessages.add(rumbleMessage);
			if (rumbleMessage.getUser() != null) {
				rumbleMessage.getUser().removeRumbleMessage(rumbleMessage);
			}
			rumbleMessage.setUser(this);
		}
	}

	public void removeRumbleMessage(RumbleMessage rumbleMessage) {
		if (rumbleMessages != null && rumbleMessages.contains(rumbleMessage)) {
			rumbleMessages.remove(rumbleMessage);
			rumbleMessage.setUser(null);
		}
	}

}
