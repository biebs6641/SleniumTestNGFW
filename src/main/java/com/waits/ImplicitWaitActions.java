package com.waits;

import org.apache.logging.log4j.Logger;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;
import com.report.ExtentReportManager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

public class ImplicitWaitActions {

	private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);
	
	public void setIplicitWait() {
		
		try {
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.info("Error occured while setting up Implicit wait "+e.getMessage());
		}
		
		logger.info("Implicit wait time is "+Constants.IMPLICIT_WAIT);
	}
	
}
