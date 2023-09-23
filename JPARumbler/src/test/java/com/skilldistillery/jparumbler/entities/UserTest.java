package com.skilldistillery.jparumbler.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPARumbler");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void test_User_entity_basic_mapping() {
		assertNotNull(user);
		assertEquals("jchan", user.getUsername());

	}
	
	@Test
	void test_User_blogpost_OneToMany_mapping() {
		assertNotNull(user);
		List<BlogPost> blogPosts = user.getBlogPosts();
		assertNotNull(blogPosts);
		assertTrue(blogPosts.size() > 0);

	}
	
	@Test
	void test_User_adress_OneToOne_mapping() {
		assertNotNull(user);
		assertEquals("360 High Kick Dr", user.getAddress().getStreet());
		
	}
	

}
