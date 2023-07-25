package com.qa.houpermitproject.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;

public class RequestInformationTest extends BaseTest{
	
	
	
	@Test
	public void requestInformationUpdate() {
		
		SoftAssert softAssert = new SoftAssert();
		
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		softAssert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		
		String comments = reqInfo.requestInfo("MECS2677", "Please Provide an Update");
		System.out.println("Customer updated comments: "+comments);
		softAssert.assertEquals(comments, "Please Provide an Update");
		
		softAssert.assertAll();
	}

}
