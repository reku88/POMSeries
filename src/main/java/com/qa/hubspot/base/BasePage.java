package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.hubspot.commons.Constants;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initialize_driver(Properties prop2) {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/send2/Downloads/chromedriver.exe");
		//driver = new ChromeDriver();
		tldriver.set(new ChromeDriver());
		
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/send2/Downloads/geckodriver.exe");
			//driver = new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
			
		}else if(browserName.equals("ie")) {
			
			System.setProperty("webdriver.gecko.driver", "C:/Users/send2/Downloads/geckodriver.exe");
			//driver = new InternetExplorerDriver();
			tldriver.set(new InternetExplorerDriver());
			
		}else {
			
			System.out.println("No browser is defined");
			
		}
		
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		
		if(prop.getProperty("fullscreenmode").equals("yes")) {
		getDriver().manage().window().fullscreen();
		}
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	public Properties initialize_properties() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\send2\\Documents\\workspace-sts\\MarchPOMSeriesOne\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
	

}
