package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions_4;

public class ContactsPage_5 extends BasePage {
	
	WebDriver driver;
	ElementActions_4 elementActions;
	
	
	By createContactBtn       = By.xpath("//span[text()='Create contact']");
	By createContactSecondBtn = By.xpath("//li//span[text()='Create contact']");
	
	By email     = By.id("uid-ctrl-1");
	By firstName = By.id("uid-ctrl-2");
	By lastName  = By.id("uid-ctrl-3");
	By jobTitle  = By.id("uid-ctrl-5");
	
	
	
	
	public ContactsPage_5(WebDriver driver) {
		
		this.driver    = driver;
		elementActions = new ElementActions_4(driver);
		
	}
	
	public void createNewContact(String emailVal,String firstname,String lastname,String jobtitle){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement createContactBtn1 = wait.until(ExpectedConditions.elementToBeClickable(elementActions.getElement(createContactBtn)));
		createContactBtn1.click();
		//elementActions.clickOnElement(createContactBtn);
		
		
		WebElement emailVal1 = wait.until(ExpectedConditions.elementToBeClickable(elementActions.getElement(email)));
		emailVal1.sendKeys(emailVal);
		//elementActions.sendKeysElement(email, emailVal);
		
		WebElement firstname1 = wait.until(ExpectedConditions.elementToBeClickable(elementActions.getElement(firstName)));
		firstname1.sendKeys(firstname);
		//elementActions.sendKeysElement(firstName, firstname);
		
		WebElement lastname1 = wait.until(ExpectedConditions.elementToBeClickable(elementActions.getElement(lastName)));
		lastname1.sendKeys(lastname);
		//elementActions.sendKeysElement(lastName,lastname );
		
		WebElement jobtitle1 = wait.until(ExpectedConditions.elementToBeClickable(elementActions.getElement(jobTitle)));
		lastname1.sendKeys(jobtitle);
		//elementActions.sendKeysElement(jobTitle, jobtitle);
		
		WebElement createContactBtn2 = wait.until(ExpectedConditions.elementToBeClickable(elementActions.getElement(createContactSecondBtn)));
		createContactBtn2.click();
		
		//elementActions.clickOnElement(createContactSecondBtn);
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
