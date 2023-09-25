package com.skilldistillery.jparumbler.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jparumbler.entities.Address;

@Transactional
@Service
public class AddressDAOImpl implements AddressDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Address findAddressById(int id) {
		return em.find(Address.class, id);
	}

	@Override
	public Address createAddress(Address address) {
		em.persist(address);
		return address;
	}

	@Override
	public Address updateAddress(Address address) {
		Address updatedAddress = findAddressById(address.getId());
		updatedAddress.setStreet(address.getStreet());
		updatedAddress.setStreet2(address.getStreet2());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setState(address.getState());
		updatedAddress.setZipCode(address.getZipCode());
		updatedAddress.setPhone(address.getPhone());
		return updatedAddress;
	}

	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
