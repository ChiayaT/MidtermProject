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

class LocationRatingTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private LocationRating locationRating;

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
		LocationRatingId lid = new LocationRatingId();
		lid.setUserId(3);
		lid.setLocationId(2);
		locationRating = em.find(LocationRating.class, lid);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		locationRating = null;
	}

	@Test
	void test_LocationRating_entity_basic_mapping() {
		assertNotNull(locationRating);
		assertEquals(2023, locationRating.getCreateDate().getYear());
		assertEquals("I love this place!", locationRating.getRatingComment());

	}

}
