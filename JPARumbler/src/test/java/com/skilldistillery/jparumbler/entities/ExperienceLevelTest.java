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

class ExperienceLevelTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ExperienceLevel experienceLevel;

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
		experienceLevel = em.find(ExperienceLevel.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		experienceLevel = null;
	}

	@Test
	void test_ExperienceLevel_entity_basic_mapping() {
		assertNotNull(experienceLevel);
		assertEquals("Beginner", experienceLevel.getName());

	}
	
	@Test
	void test_ExperienceLevel_OTM_UserDiscipline_mapping() {
		experienceLevel = em.find(ExperienceLevel.class, 3);
		assertNotNull(experienceLevel);
		List<UserDiscipline> userDisciplines = experienceLevel.getUserDisciplines();
		assertNotNull(userDisciplines);
		assertTrue(userDisciplines.size() > 0);

	}

}
