package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Constants;
import com.report.ExtentFactory;

public class TestDataLoader {

	private TestDataLoader() {

		String env = Constants.ENVIRONMENT;

		switch (env) {
		case "test":

			loadFile(Constants.TEST_ENV_DATA_FILE);
			break;
		case "prod":

			loadFile(Constants.PROD_ENV_DATA_FILE);
			break;
		default:
			break;
		}

	}

	private static TestDataLoader instance = new TestDataLoader();

	public static TestDataLoader getInstance() {
		return instance;
	}

	private static Properties prop;

	public static void loadFile(String path) {

		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ExtentFactory.getInstance().logStatus("Exception occured while reading config file", false);

		}

		prop = new Properties();

		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	private String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
	
	
	public String getAppURL() {
		return this.getPropertyValue("appURL");
	}
	
	public String getUsername() {
		return this.getPropertyValue("user");
	}
	
	public String getPassword() {
		return this.getPropertyValue("password");
	}
	
}
