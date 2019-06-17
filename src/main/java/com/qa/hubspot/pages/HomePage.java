package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.CommonUtil;
import com.qa.hubspot.util.ElementActions_4;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementActions_4 elementActions;
	ContactsPage_5 contactsPage;
	
	
	By homePageHeader =By.xpath("//h1[@class='private-page__title']");
	By accountName    =By.xpath("//span[@class='account-name ']");
	
	//contacts main link
	By contactMainLink  =By.id("nav-primary-contacts-branch");
	By contactSubLink   =By.id("nav-secondary-contacts");
	
	//verifying otheer links available or not in homepage
	
	By conversationMainLink =By.xpath("//li[id='nav-primary-conversations-branch']");
	By marketingMainLink    =By.xpath("//li[id='nav-primary-marketing-branch']");
	By salesMainLink        =By.xpath("//li[id='nav-primary-sales-branch']");
	By ServiceMainLink      =By.xpath("//li[id='nav-primary-service-branch']");
	By automationMainLink   =By.xpath("//li[id='nav-primary-automation-branch']");	
	By addReportButtonLink  =By.linkText("Add report");
	
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		elementActions = new ElementActions_4(driver);
		
	}
	
	public String getHomePageTitle1() {
		return elementActions.getHomePageTitle();
	}
	
	public String getHomePageHeaderValue1() {
		return elementActions.getHomePageHeaderValue(homePageHeader);
	}
	
	public String getLoggedInAccountName1() {
		return elementActions.getLoggedInAccountName(accountName); 
		
	}
	
	//checking the links are available or not?in homepage//https://app.hubspot.com/reports-dashboard/5004418/sales
	public String verifyConverstionsLink1() {
		return elementActions.verifyConverstionsLink(conversationMainLink);		
	}
	
	public String verifyMarketingLink1() {
		return elementActions.verifyMarketingLink(marketingMainLink);
	}
	
	public String verifySalesLink1() {
		
		return elementActions.verifySalesLink(salesMainLink);
		
	}
	
	public String verifyServiceLink1() {
		return elementActions.verifySalesLink(ServiceMainLink);
		
	}
	
	public String verifyAutomationLink1() {
		return elementActions.verifyAutomationLink(automationMainLink);
		
	}
	//
	public boolean verifyAddReport1() {
		
		//return elementActions.verifyAddReport(addReportButtonLink);
		return elementActions.getElement(addReportButtonLink).isDisplayed();
		
	}
	
	public ContactsPage_5 goToContactsPage() {
		
		elementActions.clickOnElement(contactMainLink);
		CommonUtil.shortWait();
		elementActions.clickOnElement(contactSubLink);
		
		return new ContactsPage_5(driver);
				
		
	}
	
	
	
	

}
