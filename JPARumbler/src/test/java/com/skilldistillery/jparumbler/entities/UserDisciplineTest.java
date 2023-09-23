package com.skilldistillery.jparumbler.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDisciplineTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserDiscipline userDiscipline;

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
		UserDisciplineId uid = new UserDisciplineId();
		uid.setUserId(2);
		uid.setDisciplineId(2);
		userDiscipline = em.find(UserDiscipline.class, uid);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		userDiscipline = null;
	}

	@Test
	void test_UserDiscipline_entity_basic_mapping() {
		assertNotNull(userDiscipline);
		assertEquals("I'm really good at karate.", userDiscipline.getDescription());

	}

}
