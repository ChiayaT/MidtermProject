package com.skilldistillery.jparumbler.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectMessgeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private DirectMessage directMessage;

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
		directMessage = em.find(DirectMessage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		directMessage = null;
	}

	@Test
	void test_DirectMessage_entity_basic_mapping() {
		assertNotNull(directMessage);
		assertEquals(Month.SEPTEMBER, directMessage.getCreateDate().getMonth());
	}
	
	@Test
	void test_DirectMessage_sender_id_to_user_mapping() {
		assertNotNull(directMessage);
		assertNotNull(directMessage.getSenderUser());
		assertEquals("Jackie",directMessage.getSenderUser().getFirstName());
	}
	@Test
	void test_DirectMessage_recipient_id_to_user_mapping() {
		assertNotNull(directMessage);	
		assertNotNull(directMessage.getRecipientUser());	
		assertEquals("Mike",directMessage.getRecipientUser().getFirstName());
	}
}
