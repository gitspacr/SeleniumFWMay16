package com.qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		
		try {
			
			prop= new Properties();
			File file =new File("./Configuration/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String baseUrl() {
		
		try {
			
			String getUrl =prop.getProperty("url");
			return getUrl;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	public String callBrowser() {
		
		try {
			
			String getUrl =prop.getProperty("browser");
			return getUrl;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}

}
