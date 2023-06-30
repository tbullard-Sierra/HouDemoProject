package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.houpermitproject.base.BaseTest;

public class RoofingPermitTest extends BaseTest{

	Logger log = Logger.getLogger(RoofingPermitTest.class);
	
	@Test(priority =3,description="Roofing Permit")
	public void roofingPermitTest() {
		
		//log.info("clickin on Registration link and capturing Registration page header");
		String header = regPage.doClickRegLink();
		System.out.println("Header is: "+header);
		
		//log.info("Comapring actual header value with expected header value");
		Assert.assertEquals(header, "Submit a New Record","Header values not matched");
		Reporter.log("Comparing RigisterPage header"+header);
		//basePage.takesElementScreehshot(regPage.headerEle);
	}
}
