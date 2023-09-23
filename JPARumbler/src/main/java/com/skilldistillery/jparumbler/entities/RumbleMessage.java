package com.skilldistillery.jparumbler.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="rumble_message")
public class RumbleMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "message_date")
	private LocalDateTime messageDate;
	
	private String content;
	
	@Column(name="create_date")
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="rumble_id")
	private Rumble rumble;
	
	

	public RumbleMessage() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDateTime messageDate) {
		this.messageDate = messageDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Rumble getRumble() {
		return rumble;
	}

	public void setRumble(Rumble rumble) {
		this.rumble = rumble;
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
		RumbleMessage other = (RumbleMessage) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "RumbleMessage [id=" + id + ", messageDate=" + messageDate + ", content=" + content + ", createDate="
				+ createDate + "]";
	}
	
	
	
	
}
