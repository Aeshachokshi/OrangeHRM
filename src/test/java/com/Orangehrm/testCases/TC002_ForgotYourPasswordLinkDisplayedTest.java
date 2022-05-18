package com.Orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Orangehrm.pageObjects.LoginPage;

public class TC002_ForgotYourPasswordLinkDisplayedTest extends BaseClass{
	@Test
	public void forgotYourPasswordTest() {
		LoginPage lp = new LoginPage(driver);
    	boolean retval =lp.forgotYourPasswordLinkStatus();
    	Assert.assertEquals(retval, true , "Link is missing");
    	logger.info("Link is existing");
		
	}
	

}
