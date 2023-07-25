package com.qa.houpermitproject.tests;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.listeners.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class MultipleValuesRetursTest extends BaseTest{
	
	
	@Test
	public void displayMultipleValidationsTest() {
		
SoftAssert softAssert = new SoftAssert();
		
		String headerText = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(),
				prop.getProperty("ipsUsername").trim(), prop.getProperty("ipsPassword").trim());
		System.out.println("IPS Home Page header : "+headerText);
		softAssert.assertEquals(headerText, Constants.IPS_HOME_PAGE_HEADER);
		Reporter.log("Infor homepage header is: "+headerText);
		
		List<String> values = backOffice.preScreenStatusWithMulitpleValuesValidation("MECS2703");
		System.out.println(values);
		
		String preScreeMileStone = values.get(0);
		System.out.println("Pre-Screen milestone message: "+preScreeMileStone);
		softAssert.assertEquals(preScreeMileStone, Constants.MILESTONE_PRE_SCREEN_MSG);
		Reporter.log("Pre-screen milestone message is: "+preScreeMileStone);
		
		String wkTy = values.get(1);
		System.out.println("Work Type is: "+wkTy);
		Reporter.log("Work Type is: "+wkTy);
		softAssert.assertEquals(wkTy, "HVAC");
		
		
		String occTy = values.get(2);
		System.out.println("Occupancy Type is: "+occTy);
		Reporter.log("Occupancy Type is: "+occTy);
		softAssert.assertEquals(occTy, "ResSng");
		
		
		
		String appName = values.get(3);
		System.out.println("Applicataion Name is: "+appName);
		Reporter.log("Applicataion Name is: "+appName);
		softAssert.assertEquals(appName, "Test Application");
		
		softAssert.assertAll();
		
	}

}
