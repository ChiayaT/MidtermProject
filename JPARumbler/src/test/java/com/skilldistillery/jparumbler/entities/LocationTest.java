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

class LocationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Location location;

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
		location = em.find(Location.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		location = null;
	}

	@Test
	void test_Location_entity_basic_mapping() {
		assertNotNull(location);
		assertEquals(2023, location.getCreateDate().getYear());
		assertEquals("Fight Town", location.getName());

	}
	
	@Test
	void test_Location_to_location_type_mapping() {
		assertNotNull(location);
		assertNotNull(location.getLocationType());
		assertEquals("Business", location.getLocationType().getName());
	}

	@Test
	void test_Location_to_address_mapping() {
		assertNotNull(location);
		assertNotNull(location.getAddress());
		assertEquals("Denver", location.getAddress().getCity());
	}

}
