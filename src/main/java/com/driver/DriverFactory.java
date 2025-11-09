package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance() {
		
		return instance;
		
	}
	
	public void setDriver(WebDriver driverobj) {
		driver.set(driverobj);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	
}
