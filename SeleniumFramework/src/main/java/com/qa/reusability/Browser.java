package com.qa.reusability;

import org.openqa.selenium.WebDriver;

import com.qa.BaseClass.TestBase;

public class Browser extends TestBase{
	
//	public WebDriver driver;
	
	public void forward() {
		try {
			driver.navigate().forward();
			logger.info("browser forward");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void back() {
		try {
			driver.navigate().back();
			logger.info("browser back");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void refresh() {
		try {
			driver.navigate().refresh();
			logger.info("browser refresh");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void navigate(String url) {
		try {
			driver.navigate().to(url);
			logger.info("browser refresh");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
