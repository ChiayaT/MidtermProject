package com.skilldistillery.jparumbler.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.jparumbler.entities.Address;

public interface AddressDAO {

	@Autowired
	Address findAddressById(int id);

	Address createAddress(Address address);

	Address updateAddress(Address address);

	boolean deleteAddress(int id);

}
