package com.vaibhav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.vaibhav.dao.MyDAO;
import com.vaibhav.vo.User;

@Component
public class MyServiceImpl implements MyService {

	@Autowired
	MyDAO myDAO;
	
	@Override
	public Page<User> getAllUsers(Pageable pageable) {
		return myDAO.getAllUsers(pageable);
	}

	@Override
	public User getUserByName(final String name) {
		return myDAO.getUserByName(name);
	}

	@Override
	public List<User> getUserByCity(String city) {
		return myDAO.getUserByCity(city);
	}

}
