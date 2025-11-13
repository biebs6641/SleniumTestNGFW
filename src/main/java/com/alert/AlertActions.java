package com.alert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class AlertActions {

	public Logger logger = LogManager.getLogger(AlertActions.class);
	private Alert alert;

	public void swithcToAlert() {

		try {
		alert = DriverFactory.getInstance().getDriver().switchTo().alert();
		logger.info("Switched to Alert");
		ExtentFactory.getInstance().logStatus("Switched to Alert", true);
		}catch(NoAlertPresentException e) {
			logger.error("No alert Found here,exception happended");
			ExtentFactory.getInstance().logClickStatus("Exception happened while switching to alert", false);
			
			
		}

	}    
	
	
	public void acceptAlert() {
	try {
		this.alert.accept();
		logger.info("Alert is accepted");
		ExtentFactory.getInstance().logStatus("Clicked on OK button for alert", true);
	}catch(Exception e) {
		logger.info("Exception occured while clicking on OK button for alert");
		ExtentFactory.getInstance().logStatus("Exception occured while clicking on OK button for alert", true);
	}
	}
	
	
	
	public void cancelAlert() {
		try {
			this.alert.dismiss();
			logger.info("Alert is Dismissed");
			ExtentFactory.getInstance().logStatus("Clicked on cancel button for alert", true);
		}catch(Exception e) {
			logger.info("Exception occured while clicking on OK button for alert");
			ExtentFactory.getInstance().logStatus("Exception occured while clicking on cancel button for alert", true);
		}
		}

}
