package com.blogs.dao;

import com.blogs.pojos.Address;

public interface AddressDao {

	String assignUserAddress(Long userId,Address newAdr);

}
