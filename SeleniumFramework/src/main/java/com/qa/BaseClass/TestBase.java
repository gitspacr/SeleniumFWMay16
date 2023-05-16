package com.qa.BaseClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.qa.Utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	public static Logger logger;

	ReadConfig rc=new ReadConfig();
	public String getUrlVal =rc.baseUrl();
	public String getBrVal =rc.callBrowser();

	@BeforeClass
	public void setUp() {
		
		try {
			logger=(Logger) LogManager.getLogger("TestBase");
			String browser = getBrVal;
			logger.info("initialize browser");
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				logger.info("initialize chromebrowser");
			}else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				logger.info("initialize firefoxbrowser");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get(getUrlVal);//url launch
			logger.info("Application browser launched successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void getScreenshot(WebDriver driver, String capture) {
		try {
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src =ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir")+"/Screensots/"+capture+".png");
			FileUtils.copyFile(src, dest);
			logger.info("Screenshot taken");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	
	
	

}
