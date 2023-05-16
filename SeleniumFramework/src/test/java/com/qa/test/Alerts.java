package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://demo.automationtesting.in/Alerts.html");//url launch
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
//		Alert simpleAlert =driver.switchTo().alert();
//		Thread.sleep(3000);
//		simpleAlert.accept();
//		Thread.sleep(3000); 
		driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Alert promptAlert =driver.switchTo().alert();
		Thread.sleep(3000);
		String txt =promptAlert.getText();
		System.out.println(txt);
		promptAlert.dismiss();
		Thread.sleep(3000);
		driver.close();

}
	}
