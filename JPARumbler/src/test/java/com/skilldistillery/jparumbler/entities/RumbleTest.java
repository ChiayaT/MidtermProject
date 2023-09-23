package com.skilldistillery.jparumbler.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RumbleTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rumble rumble;

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
		rumble = em.find(Rumble.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rumble = null;
	}

	@Test
	void test_Rumble_entity_basic_mapping() {
		assertNotNull(rumble);
		assertEquals(2023, rumble.getCreateDate().getYear());
		assertEquals("This is the first rumble.", rumble.getDescription());

	}
	
	@Test
	void test_Rumble_user_ManyTOone_mapping() {
		assertNotNull(rumble);
		assertEquals(2, rumble.getHost().getId());

	}
	
	@Test
	void test_Rumble_to_RumbleMessage_to_Rumble_mapping() {
		List<RumbleMessage> rumbleMessages = rumble.getRumbleMessages();
		assertNotNull(rumbleMessages);
		assertTrue(rumbleMessages.size() > 0);
	}

}
