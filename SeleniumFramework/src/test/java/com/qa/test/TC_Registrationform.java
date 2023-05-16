package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.BaseClass.TestBase;
import com.qa.resources.ReadData;
import com.qa.reusability.Control;
import com.qa.pages.RegisterPage;

public class TC_Registrationform extends TestBase {
	
	
	@Test(dataProvider="passDataToExcel", dataProviderClass=ReadData.class)
	public void registationForm(String FirstName, String LastName,
			String EmailID,String PhoneNumber)
	{
		try {
			RegisterPage rp = new RegisterPage(driver);
			Thread.sleep(3000);
			rp.enterRegistrationInfo(FirstName,LastName,EmailID,PhoneNumber);
			
			logger.info("Registration info filled and refreshed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	@Test
	public void titleOfPage()
	{
		try {
			RegisterPage rp = new RegisterPage(driver);
			rp.titleOfthePage();
			logger.info("Tile of the page");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	
	@Test
	public void getCurrURL()
	{
		try {
			RegisterPage rp = new RegisterPage(driver);
			rp.getCurrentURL();
			logger.info("Tile of the page");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
