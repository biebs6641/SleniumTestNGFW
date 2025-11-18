package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.constant.Constable;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constants;
import com.report.ExtentFactory;

public class ConfigLoader {

	private Logger logger = LogManager.getLogger(ConfigLoader.class);
	private Properties prop;

	private ConfigLoader() {
		// TODO Auto-generated constructor stub

		FileReader reader = null;
		try {
			reader = new FileReader(Constants.CONFIG_FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Exception occured while reading config file");
			ExtentFactory.getInstance().logStatus("Exception occured while reading config file", false);

		}

		prop = new Properties();

		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Constants.ENVIRONMENT=getpropertyvalueKey("environment");
		
	}

	private static ConfigLoader instance = new ConfigLoader();

	public static ConfigLoader getInstance() {
		return instance;
	}

	public String getpropertyvalueKey(String key) {
		return prop.getProperty(key);
	}

}
