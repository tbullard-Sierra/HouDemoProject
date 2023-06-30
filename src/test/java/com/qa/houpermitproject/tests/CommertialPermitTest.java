package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.houpermitproject.base.BaseTest;

public class CommertialPermitTest extends BaseTest{
	
	Logger log = Logger.getLogger(CommertialPermitTest.class);
	
	@Test(priority =1,description="Verify Email Address text box available")
	public void verifyEmailAddressFieldTest() {
		Reporter.log("Verifying Email Address text box available or not");
		log.info("Verifying Email text filed available or not");
		boolean email = cohHomePage.doVerifyEmailFieldDisplay();
		//Assert.assertEquals(email, true);
		Assert.assertTrue(email);
		
	}
	
	@Test(priority =2,description="Verify password text box available",enabled =true)
	public void verifyPasswordFieldTest() {
		Reporter.log("Verifying Password text box available or not");
		log.info("Verifying Email text filed available or not");
		boolean pwd = cohHomePage.doVerifyPasswordFieldDisplay();
		//Assert.assertEquals(pwd, true);
		Assert.assertTrue(pwd);
	}

}
