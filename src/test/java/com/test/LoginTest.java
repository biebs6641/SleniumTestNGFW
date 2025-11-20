package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.properties.TestDataLoader;

public class LoginTest extends BaseTest {

	
	@Test
	public void loginWithUservalid() {
		LoginPage loginpage = new LoginPage();
		loginpage.LoginApp(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());
		
	}
	
	
}
