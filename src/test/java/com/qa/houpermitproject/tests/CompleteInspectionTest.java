package com.qa.houpermitproject.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;

public class CompleteInspectionTest extends BaseTest{

	
	@Test
	public void completeInspection() {
		
		SoftAssert softAssert = new SoftAssert();
		
		String headerText = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(),
				prop.getProperty("ipsUsername").trim(), prop.getProperty("ipsPassword").trim());
		System.out.println("Home Page header : "+headerText);
		softAssert.assertEquals(headerText, Constants.IPS_HOME_PAGE_HEADER);
		
		
		String finalMileStoneMsg = completeInspection.completeInspection("MECS2665");
		System.out.println("Milestone is: "+finalMileStoneMsg);
		
		softAssert.assertTrue(finalMileStoneMsg.contains(Constants.FINAL_MILESTONE_MSG));
		
		softAssert.assertAll();
	}
}
