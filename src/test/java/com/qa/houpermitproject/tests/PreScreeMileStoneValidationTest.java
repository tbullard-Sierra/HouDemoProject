package com.qa.houpermitproject.tests;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;

public class PreScreeMileStoneValidationTest extends BaseTest{
	
	
	@Test
	public void validatePreScreenMileStoneTest() {
		
		String wt = "HVAC";
		String oty = "ResSng";
		String apName = "Test Application";
		
		SoftAssert softAssert = new SoftAssert();
		
		String headerText = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(),
				prop.getProperty("ipsUsername").trim(), prop.getProperty("ipsPassword").trim());
		System.out.println("IPS Home Page header : "+headerText);
		softAssert.assertEquals(headerText, Constants.IPS_HOME_PAGE_HEADER);
		
		List<String> Msg =backOffice.preScreenStatusWithMulitpleValuesValidation("MECS2703");
		
		System.out.println("PreScreen Milestone message: "+Msg);
		softAssert.assertEquals(Msg.get(0), Constants.MILESTONE_PRE_SCREEN_MSG);
		softAssert.assertEquals(Msg.get(1), wt);
		softAssert.assertEquals(Msg.get(2), oty);
		softAssert.assertEquals(Msg.get(3), apName);
		
	}

}
