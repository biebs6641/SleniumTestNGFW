package com.constants;

public abstract class Constants {

	public static final String CURRENT_DIR = System.getProperty("user.dir");
	
	public static final String Execution_report_path = CURRENT_DIR+"/reports/execution.html";
	
	public static final int EXPLICIT_WAIT = 20; 
	
	public static final String CONFIG_FILE_PATH = CURRENT_DIR+"/src/test/resources/execution/config.properties"; 
	
	public static  String ENVIRONMENT;
	public static final String TEST_ENV_DATA_FILE = CURRENT_DIR + "/src/test/resources/TestData/test_data.properties";
	public static final String PROD_ENV_DATA_FILE= CURRENT_DIR + "/src/test/resources/TestData/prod_data.properties";
	
	public static final int IMPLICIT_WAIT = 20;
	
	
	
}
