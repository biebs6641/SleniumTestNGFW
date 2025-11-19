package com.waits;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class ExplicitWaitActions {

	private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);

	public void waitForElementtoBePresnt(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT));

			wait.until(ExpectedConditions.visibilityOf(element));

			logger.info(elementName + " is available on screen");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured while waiting for the element to be visible " + e.getMessage());
			ExtentFactory.getInstance().logStatus(
					"Exception Occured while waiting for the element to be visible " + e.getMessage(), false);
		}
	}

	public void waitForClickabilityElement(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT));

			wait.until(ExpectedConditions.elementToBeClickable(element));

			logger.info(elementName + "is available for click");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured while  the element to be visible " + e.getMessage());
			ExtentFactory.getInstance().logStatus(
					"Exception Occured while clicking on the element to be visible " + e.getMessage(), false);
		}
	}

}
