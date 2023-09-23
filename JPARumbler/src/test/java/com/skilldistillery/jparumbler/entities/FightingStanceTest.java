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

class FightingStanceTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private FightingStance fightingStance;

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
		fightingStance = em.find(FightingStance.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		fightingStance = null;
	}

	@Test
	void test_FightingStance_entity_basic_mapping() {
		assertNotNull(fightingStance);
		assertEquals("Orthodox", fightingStance.getStance());

	}

}
