package com.qa.reusability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.BaseClass.TestBase;

public class Control extends TestBase{
	
//	public WebDriver driver;
	
	public void enterText(String locator, String txt) {
		try {
			driver.findElement(By.xpath(locator)).sendKeys(txt);
			logger.info("browser forward");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void click(String locator) {
		try {
			driver.findElement(By.xpath(locator)).click();
			logger.info("browser back");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void isDisplayed(String locator) {
		try {
			driver.findElement(By.xpath(locator)).isDisplayed();
			logger.info("browser refresh");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void isEnabled(String locator) {
		try {
			driver.findElement(By.xpath(locator)).isEnabled();
			logger.info("browser refresh");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void isSelected(String locator) {
		try {
			driver.findElement(By.xpath(locator)).isSelected();
			logger.info("browser refresh");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
