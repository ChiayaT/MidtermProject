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

class RumbleMessageTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private RumbleMessage rumbleMessage;

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
		rumbleMessage = em.find(RumbleMessage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rumbleMessage = null;
	}

	@Test
	void test_RumbleMessage_entity_basic_mapping() {
		assertNotNull(rumbleMessage);
		assertEquals(2023, rumbleMessage.getCreateDate().getYear());
		assertEquals("This is the first Rumble message.", rumbleMessage.getContent());

	}
	
	@Test
	void test_RumbleMessage_user_ManyTOone_mapping() {
		assertNotNull(rumbleMessage);
		assertEquals(1, rumbleMessage.getRumble().getId());

	}

}
