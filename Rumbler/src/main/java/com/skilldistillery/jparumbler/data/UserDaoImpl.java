package com.skilldistillery.jparumbler.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Address;
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
		User managedUser = findUserById(user.getId());
		managedUser.setFirstName(user.getFirstName());
		managedUser.setLastName(user.getLastName());
		managedUser.setProfileImageURL(user.getProfileImageURL());
		managedUser.setHeightInInches(user.getHeightInInches());
		managedUser.setWeightInPounds(user.getWeightInPounds());
		managedUser.setDateOfBirth(user.getDateOfBirth());
		managedUser.setDescription(user.getDescription());
		Address address = user.getAddress();
		Address managedAddress = managedUser.getAddress();
		managedAddress.setState(address.getState());
		managedAddress.setStreet(address.getStreet());
		managedAddress.setStreet2(address.getStreet2());
		managedAddress.setCity(address.getCity());
		managedAddress.setPhone(address.getPhone());
		managedAddress.setZipCode(address.getZipCode());
		em.flush();
		return managedUser;
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
