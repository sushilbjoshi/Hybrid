package com.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utilities.Utilities;

public class BaseFile {

	public WebDriver driver;

	public WebDriver launchBrowser()  {

		String CDPath = Utilities.getFileParameterValue("CDPath");
		System.out.println("line no 20"+CDPath);
		
		String brName = Utilities.getFileParameterValue("browser");
		System.out.println("line no 23"+ brName);

		if ("chrome".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", CDPath);
			driver = new ChromeDriver();
		} else if ("firefox".equals(brName)) {
			System.setProperty("webdriver.gecko.driver", "GDPath");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", CDPath);
			driver = new ChromeDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
