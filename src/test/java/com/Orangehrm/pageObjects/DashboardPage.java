package com.Orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	
	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id= "menu_dashboard_index")
	WebElement lnkDashboard;
	
	
	
	public boolean  dashboardLinkDisplayedStatus() {
		boolean lnkStatus = lnkDashboard.isDisplayed();
		return lnkStatus;
		
		
	}
	
	
	
	

}
