package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Windows {
	
	WebDriver driver;
	
	String winTab ="(//button[@class='btn btn-info'])[1]";
	String lnkTxt ="//a[@class='selenium-button selenium-webdriver text-uppercase font-weight-bold']";
	
	
	public void windowTab() {
		
		try {
			
			String parentWindow = driver.getWindowHandle();
			System.out.println("parent window: "+parentWindow);
			driver.findElement(By.xpath(winTab)).click();
			Set<String> childWindow =driver.getWindowHandles();
			System.out.println("child window: "+childWindow);
			
			for (String handles : childWindow) {
				if(!handles.equals(parentWindow)) {
					driver.switchTo().window(handles);
					Thread.sleep(3000);
					driver.findElement(By.xpath(lnkTxt)).click();
					String currUrl = driver.getCurrentUrl();
					System.out.println(currUrl);
					driver.close();
					
				}
				
			}
			driver.switchTo().window(parentWindow);
			String currUrlParent = driver.getCurrentUrl();
			System.out.println(currUrlParent);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	
	
	
	
	
	

}
