package com.tech.register.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tech.register.model.User;
import com.tech.register.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationControllerTest {
	
	//Inject Mock Controller to test
	@InjectMocks
	private RegistrationController registerController;
	
	@Mock
	private UserService userService;
	
		
	//MockMvc to test the end points
	private MockMvc mockMvc;
	
	// initialize MockMvc using MockMvcBuilders on setup method
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(registerController)
					.build();
	}
	
	// Test method for save user bad request	
	@Test
	public void testSaveUser_badReq() throws Exception{
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(false);
		String json = "{\"userId\":\"sss\",\r\n" + 
				"\"firstName\":\"ddd\",\r\n" + 
				"\"email\":\"shafat1.saeed@gmail.com\",\r\n" + 
				"\"password\":\"password1\",\r\n" + 
				"\"dateOfBirth\":\"2001-11-26\",\r\n" + 
				"\"country\":\"franc\"\r\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/register/save")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(json))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}
	
	// Test method for save user bad request when country is not france	
	@Test
	public void testSaveUser_badReqCountry() throws Exception{
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(true);
		String json = "{\"userId\":\"sss\",\r\n" + 
				"\"firstName\":\"ddd\",\r\n" + 
				"\"email\":\"shafat1.saeed@gmail.com\",\r\n" + 
				"\"password\":\"password1\",\r\n" + 
				"\"dateOfBirth\":\"2001-11-26\",\r\n" + 
				"\"country\":\"franc\"\r\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/register/save")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(json))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}
		
	// Test method for save user when userId is not given
	@Test
	public void testSaveUser_badReqUserId() throws Exception{
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(true);
		String json = "{\"userId\":\"\",\r\n" + 
				"\"firstName\":\"ddd\",\r\n" + 
				"\"email\":\"shafat1.saeed@gmail.com\",\r\n" + 
				"\"password\":\"password1\",\r\n" + 
				"\"dateOfBirth\":\"2001-11-26\",\r\n" + 
				"\"country\":\"france\"\r\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/register/save")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(json))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}
	
	// Test method for save user when date of birth is less than 18 is not given
	@Test
	public void testSaveUser_badReqBirthDate() throws Exception{
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(true);
		String json = "{\"userId\":\"sss\",\r\n" + 
				"\"firstName\":\"ddd\",\r\n" + 
				"\"email\":\"shafat1.saeed@gmail.com\",\r\n" + 
				"\"password\":\"password1\",\r\n" + 
				"\"dateOfBirth\":\"2004-11-26\",\r\n" + 
				"\"country\":\"france\"\r\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/register/save")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(json))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}
	
	// Test method for save user when date of birth is greater than 18 is not given
	@Test
	public void testSaveUser_okReqBirthDate() throws Exception{
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(true);
		String json = "{\"userId\":\"sss\",\r\n" + 
				"\"firstName\":\"ddd\",\r\n" + 
				"\"email\":\"shafat1.saeed@gmail.com\",\r\n" + 
				"\"password\":\"password1\",\r\n" + 
				"\"dateOfBirth\":\"2001-11-26\",\r\n" + 
				"\"country\":\"france\"\r\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/register/save")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(json))
			.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	// Test method to get User by Id when user not found
	@Test
	public void testGetUser_badReq()throws Exception{
		
		Mockito.when(userService.getByUserId(Mockito.anyString())).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.get("/getuser/abc"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());		
	}
	
	// Test method to get User by Id when user is found
	@Test
	public void testGetUser_okReq()throws Exception{
		
		Mockito.when(userService.getByUserId(Mockito.anyString())).thenReturn(new User());
		mockMvc.perform(MockMvcRequestBuilders.get("/getuser/abc"))
		.andExpect(MockMvcResultMatchers.status().isOk());		
	}
	
}
