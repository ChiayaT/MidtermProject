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

class LocationTypeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private LocationType locationType;

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
		locationType = em.find(LocationType.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		locationType = null;
	}

	@Test
	void test_LocationType_entity_basic_mapping() {
		assertNotNull(locationType);
		assertEquals("Business", locationType.getName());

	}

	@Test
	void test_LocationType_to_location_mapping() {
		assertNotNull(locationType);
		assertNotNull(locationType.getLocations());
		assertTrue(locationType.getLocations().size() > 0);
		
	}
	

}
