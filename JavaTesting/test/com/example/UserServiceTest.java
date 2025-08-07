package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserServiceTest {
	
	private final UserService us = new UserService();

//	@Test
//	void testConnection() {
//		actualValue = DBConnUtil.getConn();
//		assertNotNull(actualValue , " DB Connection failure");
//	}
//		
//	}
//	
	//Positive test case
	@Test
	void testValidUser() {
		// actual one
		assertTrue(us.isValidUser("niti", "1234567")); // assuming that this user name exist 
	}
	
	// Negative test case
	@Test
	void testInValidUser()
	{
		//assertTrue -- Expected output
		//(us.isValidUser(null, null)) -- Actual output
		boolean status = us.isValidUser("Hello", "1234567");
		assertEquals(false , status); // To check invalid user that does not exist in a table
	}
	
	@Test
	void testShortPassword()
	{
		
		assertTrue(us.isValidUser("niti", "1234567")); // checking the password length which should be greater than 6
	}
	
	@Test
	void testEmptyInput()
	{
		
		assertFalse(us.isValidUser("niti", "")); // checking the empty fields 
	}

}
