package com.vaibhav.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vaibhav.vo.User;

public interface MyService {
	
	/**
	 * @return List<User>
	 */
	public Page<User> getAllUsers(Pageable pageable);

	/**
	 * @param name
	 * @return User
	 */
	public User getUserByName(final String name);

	/**
	 * @param city
	 * @return List<User>
	 */
	public List<User> getUserByCity(String city); 

}
