package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPageBy_4;
import com.qa.hubspot.util.CommonUtil;

public class HomePageTest {
	
	BasePage basePage;
	WebDriver driver;
	
	Properties prop;
	LoginPageBy_4 loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		CommonUtil.mediumWait();
			
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle1();
		System.out.println("home page title is" +title);
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		
		String header = homePage.getHomePageHeaderValue1();
		System.out.println("home page header is"+header);
		Assert.assertEquals(header, Constants.HOMEPAGE_HEADER);
			
	}
	
	@Test(priority=3)
	public void verifyLoggedInAccountNameTest() {
		
		String accountName = homePage.getLoggedInAccountName1();
		System.out.println("Logged in account name is"+accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountName"));
		
	}
	
	//verifying the homepage links availble or not?
	@Test
	public void verifyConversationMainLinkTest() {
		
		String conversation = homePage.verifyConverstionsLink1();
		System.out.println(" conversation main link available or not"+conversation);
		Assert.assertEquals(conversation, Constants.Conversation);
		
	}
	
	@Test
	public void verifyMarketingLinkTest() {
		
		String marketing =homePage.verifyMarketingLink1();
		System.out.println("marketing main link is availble or not"+marketing);
		Assert.assertEquals(marketing, Constants.Marketing);
		
		
	}
	
	@Test
	public void verifySalesLinkTest() {
		String sales = homePage.verifySalesLink1();
		System.out.println("sales main link is availble or not"+sales);
		Assert.assertEquals(sales, Constants.Sales);
		
		
	}
	
	@Test
	public void verifyServiceLinkTest() {
		
		String service = homePage.verifyServiceLink1();
		System.out.println("service main link is available or not"+service);
		Assert.assertEquals(service, Constants.Service);
			
	}
	
	@Test
	public void verifyAutomationLinkTest() {
		
		String automation = homePage.verifyAutomationLink1();
		System.out.println("automation main link is available or not"+automation);
		Assert.assertEquals(automation, Constants.Automation);
	}
	
	@Test
	public void verifyAddReportLinkTest() {
		
		boolean report = homePage.verifyAddReport1();
		System.out.println("automation main link is available or not"+report);
		Assert.assertEquals(report, Constants.addReport);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
