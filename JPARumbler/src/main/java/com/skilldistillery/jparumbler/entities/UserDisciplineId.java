package com.skilldistillery.jparumbler.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserDisciplineId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "discipline_id")
	private int disciplineId;

	public UserDisciplineId() {
		super();
	}

	public UserDisciplineId(int userId, int disciplineId) {
		super();
		this.userId = userId;
		this.disciplineId = disciplineId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(int disciplineId) {
		this.disciplineId = disciplineId;
	}

	@Override
	public String toString() {
		return "UserDisciplineId [userId=" + userId + ", disciplineId=" + disciplineId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(disciplineId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDisciplineId other = (UserDisciplineId) obj;
		return disciplineId == other.disciplineId && userId == other.userId;
	}
	
	

}
