package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;

public class IPSLoginTest extends BaseTest {

	
	@Test
	public void backOfficeLogin() {
		
		String headerText = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(),
				prop.getProperty("ipsUsername").trim(), prop.getProperty("ipsPassword").trim());
		
		System.out.println("Home Page header : " + headerText);
		Assert.assertEquals(headerText, Constants.IPS_HOME_PAGE_HEADER);

		
		
	}
}
