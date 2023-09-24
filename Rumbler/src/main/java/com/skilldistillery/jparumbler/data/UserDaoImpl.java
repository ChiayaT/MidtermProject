package com.skilldistillery.jparumbler.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.User;

@Service
@Transactional
public class UserDaoImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User authenticateUser(User user) {
		User authUser = null;
		String jpql = "SELECT u FROM User u WHERE u.username = :un AND u.password = :pw AND u.enabled = true";
		try {
			authUser = em.createQuery(jpql, User.class).setParameter("un", user.getUsername())
					.setParameter("pw", user.getPassword()).getSingleResult();
		} catch (Exception e) {
			System.err.println("Invalid user: " + user);
		}

		return authUser;
	}

	@Override
	public User findUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User newUser = findUserById(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setProfileImageURL(user.getProfileImageURL());
		newUser.setHeightInInches(user.getHeightInInches());
		newUser.setWeightInPounds(user.getWeightInPounds());
		newUser.setDateOfBirth(user.getDateOfBirth());
		newUser.setDescription(user.getDescription());
		newUser.setAddress(user.getAddress());
		return newUser;
	}

	@Override
	public boolean deleteUser(int id) {
		User deletedUser = em.find(User.class, id);
		if (deletedUser != null) {
			deletedUser.setEnabled(false);
			return true;
		}
		return false;
	}

}
