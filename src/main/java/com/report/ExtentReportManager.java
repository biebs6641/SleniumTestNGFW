package com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.Constants;

public class ExtentReportManager {

	public static ExtentReports setUpExtentReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.Execution_report_path);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
