package com.vaibhav.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.vaibhav.vo.User;

//@Transactional
@Repository
public class MyDAOImpl implements MyDAO {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	@Override
	public Page<User> getAllUsers(Pageable pageable) {
		// When DB is connected
		/*String sql = "SELECT name, city FROM testone";
		return this.jdbcTemplate.query(sql, new UserRowMapper());*/
		
		// When DB is not connected
		int total = 5;
		List<User> userList = getAllUsersList(pageable.getPageNumber(), pageable.getPageSize(), total);
		
		return new PageImpl<>(userList, pageable, total);
	}

	@Override
	public User getUserByName(final String name) {
		// When DB is connected
		/*String sql = "SELECT name, city FROM testone WHERE name = ?";
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);*/
		
		// When DB is not connected
		List<User> userList = getAllUsersList(1, 5, 5);
		ListIterator<User> userListIterator = userList.listIterator();
		User user = null;
		boolean isNameFound = false;
		while (userListIterator.hasNext()) {
			user = userListIterator.next();
			if(user.getName().equalsIgnoreCase(name)) {
				isNameFound = true;
				break;
			}
		}
		if(isNameFound) {
			return user;
		}
		return null;
	}

	@Override
	public List<User> getUserByCity(final String city) {
		// When DB is connected
		/*String sql = "SELECT name, city FROM testone WHERE city = ?";
		Object[] param = { city };
		return this.jdbcTemplate.query(sql, param, new UserRowMapper());*/
		
		// When DB is not connected
		List<User> response = new ArrayList<User>();
		List<User> userList = getAllUsersList(1, 5, 5);
		ListIterator<User> userListIterator = userList.listIterator();
		boolean isCityFound = false;
		while (userListIterator.hasNext()) {
			User user = userListIterator.next();
			if(user.getCity().equalsIgnoreCase(city)) {
				isCityFound = true;
				response.add(user);
			}
		}
		if(isCityFound) {
			return response;
		}
		return null;
	}
	
	private List<User> getAllUsersList(int from, final int size, final int total) {
		if(from > total) {
			return new ArrayList<User>();
		}
		
		List<User> userList = new ArrayList<User>();
		for(int i = 1; i <= size; i++, from++) {
			userList.add(new User("Name" + from, "City" + from));
		}
		return userList;
	}
}
