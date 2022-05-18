package com.Orangehrm.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	@BeforeClass
	@Parameters("browser")
	
	public void setup(String br) throws IOException
	
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\Config.properties");
		
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			logger.info("Chrome browser is launched");
			
			
		} else if (br.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
			logger.info("Edge browser is launched");
			
			
		}else if (br.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
			logger.info("Firefox browser is launched");
			
		} else {
			 
			logger.info("Please pass value");
			
		}
		
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		logger.info("Application is opened");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
		logger.info("Close application Successfully.");
		
	}
}
