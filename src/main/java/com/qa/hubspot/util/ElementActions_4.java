package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;

public class ElementActions_4 extends BasePage {
	
	WebDriver driver;
	
	public ElementActions_4(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public WebElement getElement(By selector) {
		WebElement element = null;
		
		try {
		
		WebDriverWait wait = new WebDriverWait(driver,Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		
		element = driver.findElement(selector);
		}catch(Exception e) {
			
			System.out.println("element could not be created");
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		return element;
		
	}
	
	public void sendKeysElement(By selector,String value) {
		try {
		getElement(selector).sendKeys(value);
		}
		catch(Exception e) {
			
			System.out.println("some issue with sendkeys");
			
		}
	}
	
	public void clickOnElement(By selector) {
		
		getElement(selector).click();
	}
	
	public String getTextElement(By selector) {
		
		return getElement(selector).getText();
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
		
		
		
		
	}
	
	//HomePage
	
	public String getHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public String getHomePageHeaderValue(By selector) {
		return getElement(selector).getText();
	}
	
	public String getLoggedInAccountName(By selector) {
		
		return getElement(selector).getText();
		
	}
	
	
	//verifying whether the links are available or not?
	
	public String verifyConverstionsLink(By selector) {
		return getElement(selector).getText();
	}
	
	public String verifyMarketingLink(By selector) {
		return getElement(selector).getText();
	}
	
	public String verifySalesLink(By selector) {
		return getElement(selector).getText();
	}
	
	public String verifyServiceLink(By selector) {
		return getElement(selector).getText();
	}
	
	public String verifyAutomationLink(By selector) {
		return getElement(selector).getText();
	}
	
	public String verifyAddReport(By selector) {
		return getElement(selector).getText();
	}
	
	//ContactsPage_5 
	
	/*public void createNewContact(String emailVal,String firstname, String lastname, String jobtitle) {
		
		By selector=null;
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement createContactBtn1 = wait.until(ExpectedConditions.elementToBeClickable(getElement(selector)));
		createContactBtn1.click();
		
		WebElement emailVal1 = wait.until(ExpectedConditions.elementToBeClickable(getElement(selector)));
		emailVal1.sendKeys(emailVal);
		
		WebElement firstname1 = wait.until(ExpectedConditions.elementToBeClickable(getElement(selector)));
		emailVal1.sendKeys(firstname);
		
		WebElement lastname1 = wait.until(ExpectedConditions.elementToBeClickable(getElement(selector)));
		emailVal1.sendKeys(lastname);
		
		WebElement jobtitle1 = wait.until(ExpectedConditions.elementToBeClickable(getElement(selector)));
		emailVal1.sendKeys(jobtitle);
		
		WebElement createContactBtn2 = wait.until(ExpectedConditions.elementToBeClickable(getElement(selector)));
		createContactBtn2.click();
		
		
		
		
	
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
