package com.Orangehrm.testCases;



import org.testng.Assert;

import org.testng.annotations.Test;

import com.Orangehrm.pageObjects.DashboardPage;
import com.Orangehrm.pageObjects.LoginPage;
public class TC001_UserLoginTest extends BaseClass {
	
	
	@Test
	public void loginTest() {
		
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = new DashboardPage(driver);
		lp.setUsername(prop.getProperty("appusername"));
		lp.setPassword(prop.getProperty("apppassword"));
		lp.clickLoginBtn();
		
	boolean status = dp.dashboardLinkDisplayedStatus();
	Assert.assertEquals(status, true , "User did not logged successfully");
	logger.info("User logged into application successfully");
		
	}
	
	

	
	

}
