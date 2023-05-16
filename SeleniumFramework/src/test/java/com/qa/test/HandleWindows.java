package com.qa.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.Windows;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows extends Windows {
	
	static WebDriver driver;
	static Windows win;
	
	@BeforeMethod
	public void launcgBrowser() {
		
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://demo.automationtesting.in/Windows.html");//url launch
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public static void windowHandle() throws Exception {
		try {
			win = new Windows();
			win.windowTab();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();

		
	}

}
