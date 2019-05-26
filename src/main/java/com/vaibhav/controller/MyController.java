package com.vaibhav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.constant.MyConstant;
import com.vaibhav.service.MyService;
import com.vaibhav.vo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@Api(value="MySQL CRUD Operations", description="MySQL CRUD operations")
public class MyController {

	@Autowired
	MyService myService;
	
	@ApiOperation(value = "View a list of available users", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = MyConstant.GET_ALL_USERS, method = RequestMethod.GET, produces = MyConstant.PRODUCES_RESPONCE_TYPE)
	public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
		Page<User> userList = myService.getAllUsers(pageable);
		ResponseEntity<Page<User>> response = new ResponseEntity<>(userList, HttpStatus.OK);
		return response;

		//return new ResponseEntity<List<User>>(myService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = MyConstant.GET_USER_BY_NAME, method = RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@RequestParam("name") String name) {
		return new ResponseEntity<User>(myService.getUserByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = MyConstant.GET_USER_BY_CITY, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserByCity(@RequestParam("city") String city) {
		return new ResponseEntity<List<User>>(myService.getUserByCity(city), HttpStatus.OK);
	}
}
