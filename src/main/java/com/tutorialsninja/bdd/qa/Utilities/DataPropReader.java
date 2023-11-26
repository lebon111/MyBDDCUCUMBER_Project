package com.tutorialsninja.bdd.qa.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class DataPropReader {
	
	public static Properties dataprop;
	public static FileInputStream idp;
	
	public static Properties initializeDataPropPropertiesFile() throws Exception {
		dataprop = new Properties();
		idp = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties_files\\dataprop.properties");
		dataprop.load(idp);
		
		return dataprop;
	}

}
