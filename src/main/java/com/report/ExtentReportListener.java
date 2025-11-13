package com.report;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ExtentReportListener implements ITestListener {
	
	private static Logger logger = LogManager.getLogger(ExtentReportListener.class);
	
	private ExtentReports extentreports;
	private ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		this.extentTest = extentreports.createTest(result.getName());
		ExtentFactory.getInstance().setExtent(extentTest);
		logger.info("Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().logStatus(result.getName(), true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().fail("Exception Details"+result.getThrowable().getMessage()); 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.SKIP,"test cases "+result.getName()+" is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		this.extentreports = ExtentReportManager.setUpExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		this.extentreports.flush();  
	}
	
	
	
	

}
