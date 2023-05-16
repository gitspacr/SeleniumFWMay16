package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.TestBase;
import com.qa.reusability.Control;

public class RegisterPage extends TestBase{
	
	public WebDriver driver;
	Control control =new Control();
	//define object and its corresponding method
	// 3 ways to define Objects
	
	//1 way
//	String txtFirstName = "//input[@placeholder='First Name']";
//	String txtLastName = "//input[@placeholder='Last Name']";
	
	//2 way
	
//	By txtFirstName = By.xpath("//input[@placeholder='First Name']");
//	By txtLastName = By.xpath("//input[@placeholder='Last Name']");
//	By txtEmailID = By.xpath("//input[@type='email']");
//	By txtPhoneNumber = By.xpath("//input[@type='tel']");
//	By rdbtnFemale = By.xpath("//input[@value='FeMale']");
//	By btnRefresh = By.xpath("//button[@id='Button1']");
	
	//3 way - page factory
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement txtEmailID;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//input[@value='FeMale']")
	WebElement rdbtnFemale;
	
	@FindBy(xpath="//button[@id='Button1']")
	WebElement btnRefresh;
	
	public RegisterPage(WebDriver ldriver){
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	public void enterRegistrationInfo(String FirstName, String LastName,
			String EmailID,String PhoneNumber) {
		
		try {
			
			txtFirstName.sendKeys(FirstName);
			txtLastName.sendKeys(LastName);
			txtEmailID.sendKeys(EmailID);
			txtPhoneNumber.sendKeys(PhoneNumber);
			logger.info("Enter all the mandatory fields");
			rdbtnFemale.click();
			getScreenshot(driver, "RegisterPageRefresh");
			Thread.sleep(3000);
			btnRefresh.click();
			logger.info("Refresh button is clicked");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void titleOfthePage() {
		
		try {
		
		System.out.println(driver.getTitle());
		getScreenshot(driver, "TitleOfThePage");
		logger.info("title of the page");
		} catch (Exception e) {
			
		}
		
		
	}
	

}
