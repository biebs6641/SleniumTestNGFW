package com.report;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.driver.DriverFactory;

public class ExtentFactory {

	// Singleton Pattern
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	private ExtentFactory() {

	}

	private static ExtentFactory instance = new ExtentFactory();

	public static ExtentFactory getInstance() {
		return instance;
	}

	public void setExtent(ExtentTest obj) {
		extent.set(obj);
	}

	public ExtentTest getExtent() {
		return extent.get();
	}

	public void removeTest() {
		extent.remove();
	}

	public static String captureApplicationScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver();
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(fileContent);

	}

	/**
	 * Logs the success or failure of a click action.
	 *
	 * @param ButtonName The name of the button being clicked.
	 * @param isSuccess  True if the click was successful, false otherwise.
	 */
	public static void logClickStatus(String ButtonName, boolean isSuccess) {
	    if (isSuccess) {
	        getInstance().getExtent().pass(ButtonName + " Button is clicked successfully");
	    } else {
	        getInstance().getExtent().fail(ButtonName + " Button is not clicked");
	    }
	}
	
	/**
	 * Logs the success or failure of a sendKeys action.
	 *
	 * @param elementName The name of the input field (e.g., "Username", "Password").
	 * @param valueSent   The text value that was sent to the element.
	 * @param isSuccess   True if the action was successful, false otherwise.
	 */
	public static void logSendKeysStatus(String elementName, String valueSent, boolean isSuccess) {
	    String logMessage = elementName + " Field is " + (isSuccess ? "filled successfully with: " : "not filled with: ") + valueSent;
	    
	    if (isSuccess) {
	        getInstance().getExtent().pass(logMessage);
	    } else {
	        getInstance().getExtent().fail(logMessage);
	    }
	}
	
	
	/**
	 * Logs a custom message to the report as either PASS or FAIL.
	 *
	 * @param message   The descriptive message to log (e.g., "Page title is correct", "Test Case: LoginTest is FAILED").
	 * @param isSuccess True to log the message as PASS, false to log as FAIL.
	 */
	public static void logStatus(String message, boolean isSuccess) {
	    if (isSuccess) {
	        getInstance().getExtent().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	    } else {
	        getInstance().getExtent().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(captureApplicationScreenshot()).build());
	    }
	}
	
	

}
