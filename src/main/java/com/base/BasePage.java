package com.base;

import org.openqa.selenium.WebElement;

import com.alert.AlertActions;
import com.iframe.IframeActions;
import com.javascript.JavaScriptActions;
import com.report.ExtentFactory;
import com.waits.ExplicitWaitActions;

public class BasePage {

	protected AlertActions alertactionsObj;
	protected IframeActions iframeactionsObj;
	protected JavaScriptActions javascriptObj;
	protected ExplicitWaitActions explicitObj;

	protected BasePage() {
		alertactionsObj = new AlertActions();
		iframeactionsObj = new IframeActions();
		javascriptObj = new JavaScriptActions();
		explicitObj = new ExplicitWaitActions();

	}

	public void click(WebElement element, String elementName) {
		explicitObj.waitForClickabilityElement(element, elementName);
		element.click();
		ExtentFactory.getInstance().logClickStatus(elementName + " is clicked", true);
	}

	public void sendKeys(WebElement element, String elementName, String value) {
		explicitObj.waitForElementtoBePresnt(element, elementName);
		element.clear();
		element.sendKeys(value);
		ExtentFactory.getInstance().logStatus(value + " is entered in the " + elementName, true);

	}

	public boolean isElementSelected(WebElement element, String elementName) {

		explicitObj.waitForElementtoBePresnt(element, elementName);

		return element.isSelected();

	}

	public void selectCheckbox(WebElement element, String elementName) {

		explicitObj.waitForElementtoBePresnt(element, elementName);

		if (this.isElementSelected(element, elementName) == false) {
			this.click(element, elementName);
		}else {
			ExtentFactory.getInstance().logStatus(elementName + " is already selected", true);
		}

	}

}
