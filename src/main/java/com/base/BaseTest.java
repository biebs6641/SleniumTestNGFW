package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.driver.BrowserFactory;
import com.driver.DriverFactory;
import com.properties.ConfigLoader;
import com.properties.TestDataLoader;

public class BaseTest {

	@BeforeSuite
	public void setUp() {

		WebDriver driver = BrowserFactory
				.createBrowserInstance(ConfigLoader.getInstance().getpropertyvalueKey("browser"));
		DriverFactory.getInstance().setDriver(driver);
		DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppURL());
	}

	@AfterSuite
	public void tearDoen() {
		DriverFactory.getInstance().getDriver().quit();
	}

}
