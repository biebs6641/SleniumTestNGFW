package com.iframe;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class IframeActions {

	private Logger logger = LogManager.getLogger(IframeActions.class);

	public void waitforIframeAndSwitch(String idorName) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idorName));

			logger.info("Switched to iframe " + idorName);
			ExtentFactory.getInstance().logStatus("Switched to iframe " + idorName, true);
		} catch (Exception e) {
			logger.error("Error occured while switching to the Frame " + idorName);
			ExtentFactory.getInstance().logStatus("Error occured while switching to the Frame " + idorName, false);
		}

	}

	public void waitforIframeAndSwitch(int index) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
			logger.info("Switched to iframe " + index);
			ExtentFactory.getInstance().logStatus("Switched to iframe " + index, true);
		} catch (Exception e) {
			logger.error("Error occured while switching to the Frame " + index);
			ExtentFactory.getInstance().logStatus("Error occured while switching to the Frame " + index, false);
		}

	}

	public void switchToDefaultContent() {

		try {
			DriverFactory.getInstance().getDriver().switchTo().defaultContent();
			logger.info("Switched to default content");
			ExtentFactory.getInstance().logStatus("Switched to default content", true);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured to while Switching to default content");
			ExtentFactory.getInstance().logStatus("Error occured to while Switching to default content", false);
		}

	}

}
