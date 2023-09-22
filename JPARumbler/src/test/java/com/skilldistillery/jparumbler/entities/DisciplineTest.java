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

class DisciplineTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Discipline discipline;

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
		discipline = em.find(Discipline.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		discipline = null;
	}

	@Test
	void test_Discipline_entity_basic_mapping() {
		assertNotNull(discipline);
		assertEquals("Boxing", discipline.getName());

	}

}
