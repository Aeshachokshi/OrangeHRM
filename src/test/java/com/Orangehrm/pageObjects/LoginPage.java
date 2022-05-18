package com.Orangehrm.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Orangehrm.testCases.BaseClass;

public class LoginPage extends BaseClass {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {// create constructor
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(id="txtUsername")
	WebElement txtUname;
	
	@FindBy(id="txtPassword")
	WebElement txtpwd;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy (id ="forgotPasswordLink")
	WebElement forgotYourPasswordLink;
	
	public void setUsername(String uname) 
	{
		txtUname.clear();
		txtUname.sendKeys(uname);
		String val = txtUname.getAttribute("value");
		logger.info("Username - " +val+ " is entered");
		
	}
	public void setPassword(String pwd) 
	{
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
		String val = txtpwd.getAttribute("value");
		logger.info("Password - " +val+ " is entered");
	}
	
	public void clickLoginBtn() 
	{
		
		loginBtn.click();
		logger.info("Clicked on LOGIN button");
		
	}
	public boolean forgotYourPasswordLinkStatus() {
	boolean status =forgotYourPasswordLink.isDisplayed();
	return status;	
		
	}

}
