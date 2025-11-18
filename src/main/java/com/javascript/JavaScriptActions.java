package com.javascript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class JavaScriptActions {

	private Logger logger = LogManager.getLogger(JavaScriptActions.class);

	public void click(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("arguments[0].click;", element);
			logger.info("Element clicked");
			ExtentFactory.getInstance().logStatus("Element clicked", true);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error occured while clicking on element via Javascript executor");
			ExtentFactory.getInstance().logStatus(
					"error occured while clicking on element via Javascript executor" + e.getMessage(), false);

		}

	}

	public void sendKeys(WebElement element, String value) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("arguments[0].value='" + value + "'", element);

			logger.info("Value is entered : " + value);
			ExtentFactory.getInstance().logStatus("Value is entered : " + value, true);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error occured while entering value in element via Javascript executor");
			ExtentFactory.getInstance()
					.logStatus("error occured while entering value in element via Javascript executor", false);

		}

	}

	public void scrollPageToViewElement(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			logger.info("Element is visible on view");
			ExtentFactory.getInstance().logStatus("Element is visible on view", true);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured while Scrolling via Javascript executor");
			ExtentFactory.getInstance().logStatus("Exception occured while Scrolling via Javascript executor", false);

		}

	}

	public void scrollPageToEnd(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

			logger.info("Page is Scrolled to End");
			ExtentFactory.getInstance().logStatus("Page is Scrolled to End", true);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured while Scrolling page till end");
			ExtentFactory.getInstance().logStatus("Exception occured while Scrolling page till end", false);

		}

	}

}
