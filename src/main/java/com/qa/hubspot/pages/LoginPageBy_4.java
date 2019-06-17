package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions_4;
import com.qa.hubspot.util.JavaScriptUtil;

public class LoginPageBy_4 extends BasePage {
	
	WebDriver driver;
	ElementActions_4 elementActions;
	JavaScriptUtil jsUtil;
	
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	public LoginPageBy_4(WebDriver driver) {
		System.out.println(" ====================() 1");
		this.driver = driver;
		System.out.println(" ====================() 2");
	    elementActions = new ElementActions_4(driver);
	    System.out.println(" ====================() 3");
	     jsUtil = new JavaScriptUtil(driver);
	     System.out.println(" ====================() 4");
	}
	
	//define the actions/methods
	
	public String getLoginPageTitle() {
		System.out.println(" ====================elementActions.getPageTitle() "+elementActions.getPageTitle());
		return elementActions.getPageTitle();
	}
	
	public boolean verifySignUpLink() {
		return elementActions.getElement(signUpLink).isDisplayed();
		
	}
	
	public HomePage doLogin(String un, String pwd) {
		elementActions.sendKeysElement(username,un );
		elementActions.sendKeysElement(password, pwd);
		//elementActions.clickOnElement(loginBtn);
		jsUtil.clickElementByJS(elementActions.getElement(loginBtn));
		
		return new HomePage(driver);
		
		
		
	}
	
	

}
