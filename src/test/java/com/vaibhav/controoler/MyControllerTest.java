package com.vaibhav.controoler;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vaibhav.constant.MyConstant;
import com.vaibhav.controller.MyController;
import com.vaibhav.service.MyService;

/**
 * @author Vaibhav
 *
 */
public class MyControllerTest {

	@InjectMocks
	private MyController myController;
	@Mock
	private MyService myService;
	
	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
	}

	/**
	 * Test getAllUsers method
	 * @throws Exception
	 */
	//@Test
	public void testGetAllUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(MyConstant.GET_ALL_USERS)
				)
		//.andExpect(status().isOk())
			.andDo(print());
	}
}
