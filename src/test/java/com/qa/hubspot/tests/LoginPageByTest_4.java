package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.LoginPageBy_4;
import com.qa.hubspot.util.CommonUtil;

public class LoginPageByTest_4 {
	
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPageBy_4 loginPageBy;
	
	@BeforeMethod
	public void setup() {
		
		basePage = new BasePage();
		System.out.println(" ====================1");
		prop 	= basePage.initialize_properties();
		driver  = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		System.out.println(" ====================2");
		loginPageBy = new LoginPageBy_4(driver);
		System.out.println(" ====================loginPageBy"+loginPageBy);
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		System.out.println(" ====================entering"+loginPageBy);
		String title = loginPageBy.getLoginPageTitle();
		System.out.println(" login page title is" +title);
		Assert.assertEquals(title, Constants.LOGINPAGE_TITLE,"login page title is not correct");
			
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		
		Assert.assertTrue(loginPageBy.verifySignUpLink(),"signup link is not visible");
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		
		loginPageBy.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	

}

//<scope>test</scope>


















