package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage_5;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPageBy_4;
import com.qa.hubspot.util.CommonUtil;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest_5 {
	
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPageBy_4 loginPageBy;
	HomePage homePage;
	ContactsPage_5 contactsPage;
	
	
	@BeforeMethod
	public void setup() {
		
		basePage = new BasePage();
		prop 	= basePage.initialize_properties();
		driver  = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		loginPageBy = new LoginPageBy_4(driver);
		homePage = loginPageBy.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		CommonUtil.mediumWait();
		contactsPage = homePage.goToContactsPage();
		
	}
	
	@DataProvider(name ="getContactsData")
	public Object[][] getcontactsTestData() {
		
		Object contactsData[][] = ExcelUtil.getTestData("contacts");
		return contactsData;
		
		
		
	}
	
	@Test(dataProvider="getContactsData")
	public void createContactsTest(String email,String firstName,String lastName,String jobTitle) {
		
		//contactsPage.createNewContact("test@gmail.com", "Tom", "Peter", "QA Lead");
		
		contactsPage.createNewContact(email, firstName, lastName, jobTitle );
		
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	

}
