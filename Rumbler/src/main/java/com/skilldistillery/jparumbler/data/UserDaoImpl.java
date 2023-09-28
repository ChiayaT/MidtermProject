package com.skilldistillery.jparumbler.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Address;
import com.skilldistillery.jparumbler.entities.User;
import com.skilldistillery.jparumbler.entities.UserDiscipline;

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
		user.setRole("user");
		user.setEnabled(true);
		em.persist(user.getAddress());
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
	@Override
	public List<User> findUsersByName(String name) {
		List<User> users = null;
		String spql = "select u from User u where u.username like :name or "
				+ "u.firstName like :name or u.lastName like :name";
		users =  em.createQuery(spql, User.class).setParameter("name", "%" + name + "%").getResultList();
		return users;
	}
	@Override
	public List<User> findUsersByZip(String zip) {
		List<User> users = null;
		String spql = "select u from User u where u.address.zipCode = :zip";
		users = em.createQuery(spql, User.class).setParameter("zip",zip).getResultList();
		return users;
	}
	@Override
	public List<User> findUsersDiscipline(String disciplineName) {
		List<User> users = null;
		String spql = "select u from User u join fetch u.userDisciplines ud where ud.discipline.name like :disciplineName and ud.enabled = true";
		users = em.createQuery(spql, User.class).setParameter("disciplineName", "%" + disciplineName + "%" ).getResultList();
		return users;
	}

	@Override
	public List<UserDiscipline> findAllDisciplinesForUser(int id) {
		List<UserDiscipline> userDisciplines = null;
		String jpql = "select ud from UserDiscipline ud where user_id = :id and enabled = true";
		userDisciplines = em.createQuery(jpql, UserDiscipline.class).setParameter("id", id).getResultList();
		return userDisciplines;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> allUsers = null;
		String jpql = "select u from User u";
		allUsers = em.createQuery(jpql, User.class).getResultList();
		return allUsers;
	}	

}
