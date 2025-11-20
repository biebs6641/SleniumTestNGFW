package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class LoginPage extends BasePage{

	@FindBy (id="username_id")
	private WebElement userTextBox;
	
	@FindBy (id= "password")
	private WebElement passwordText;
	
	@FindBy (id="login")
	private WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
		
	}
	
	
	public void LoginApp(String userName,String passWord) {
		
		super.sendKeys(userTextBox, "userName TextBox", userName);
		super.sendKeys(passwordText, "password TextBox", passWord);
		super.click(loginButton, "Login Button");
		
	}
}
